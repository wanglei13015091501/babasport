package com.itheima.core.controller;

import com.itheima.common.utils.RequestUtils;
import com.itheima.core.pojo.sso.User;
import com.itheima.core.service.buyer.BuyerService;
import com.itheima.core.service.buyer.SessionProvider;
import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 登录控制
 * @Auther: wanglei
 * @Date: 2019.09.19
 * @Description: com.itheima.core.controller
 * @version: 1.0
 */
@Controller
public class LoginController {

    @Autowired
    private BuyerService buyerService;
    @Autowired
    private SessionProvider sessionProvider;

    //	去登陆页面
    @RequestMapping(value = "/login.aspx",method=RequestMethod.GET)
    public String login(){
        return "login";
    }

    ///提交登陆
    @RequestMapping(value = "/login.aspx",method = RequestMethod.POST)
    public String login(String username, String password, String ReturnUrl, Model model
            , HttpServletRequest request, HttpServletResponse response){
//        //判断验证码不能为空
//        //判断验证码必须正确
//        //判断验证码超时
//        //判断用户名不能为空
//        if(null != username){
//            //判断
//            if(null!= password){
//                //判断用户名必须正确
//                Buyer buyer = buyerService.selectBuyerByUsername(username);
//                if(null != buyer){
//                    //判断密码必须正确
//                    if(buyer.getPassword().equals(encodePassword(password))){
//                        //保存用户对象到Session（远程Session)
//                        sessionProvider.setAttributeForUsername(
//                                RequestUtils.getCSESSIONID(request, response), buyer.getUsername());
//                        //返回之前访问的页面
//                        return "redirect:" + ReturnUrl;
//
//                    }else{
//                        model.addAttribute("error", "密码必须正确 ");
//                    }
//                }else{
//                    model.addAttribute("error", "用户名必须正确 ");
//                }
//            }else{
//                model.addAttribute("error", "密码不能为空");
//            }
//        }else{
//            model.addAttribute("error", "用户名不能为空");
//        }
//
//        return "login";
        try {
            //获得shiro的Subject对象,代表当前用户
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(username,password);
            subject.login(token);
            User user = (User) subject.getPrincipal();

            // 保存用户对象到远程Session（即redis),下次访问的时候就不用再次登录
            //方式一:request.getSession().setAttribute("loginUser",user);
            sessionProvider.setAttributeForUsername(RequestUtils.getCSESSIONID(request, response), user.getUsername());
            //返回之前访问的页面
            return "redirect:" + ReturnUrl;
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            //认证失败,因为输入的username不存在
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            //认证失败,因为密码输入错误
            return "login";
        }

    }

    //加密
    public String encodePassword(String password){
        String algorithm = "MD5";
        char[] encodeHex = null;
        //回盐
//		password = "q3fbe54rfd8888bvn4ytnmruytygm65yhe4ewqfbnr674wt4qr";

        try {
            MessageDigest instance = MessageDigest.getInstance(algorithm);
            byte[] digest = instance.digest(password.getBytes());
            //再进行一次十六制
            encodeHex = Hex.encodeHex(digest);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new String(encodeHex);
    }

    public static void main(String[] args) {
        LoginController l = new LoginController();
        String p = l.encodePassword("123456");
        System.out.println(p);
    }
    //是否登陆
    @RequestMapping(value = "/isLogin.aspx")
    public @ResponseBody
    MappingJacksonValue isLogin(String callback, HttpServletRequest request, HttpServletResponse response){
        Integer result = 0;
        String username = sessionProvider.getAttributeForUsername(RequestUtils.getCSESSIONID(request, response));
        if(null != username){
            result = 1;
        }
        //Spring提供对象
        MappingJacksonValue mjv = new MappingJacksonValue(result);
        mjv.setJsonpFunction(callback);

        return mjv;
    }
}
