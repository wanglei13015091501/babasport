package com.itheima.common.utils;

import com.itheima.common.web.Constants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 令牌生成
 * @类名:RequestUtils
 * @描述:TODO
 * @作者:wanglei
 * @日期:19/9/19 下午11:05
 * @版本:1.0
 **/

public class RequestUtils {
    //令牌生成
    public static String getCSESSIONID(HttpServletRequest request, HttpServletResponse response){
        //从 Cookie 中获取令牌
        Cookie[] cookies = request.getCookies();
        if(null != cookies && cookies.length > 0){
            for (Cookie cookie : cookies) {
                if(Constants.CSESSIONID.equals(cookie.getName())){
                    //有  直接返回
                    return cookie.getValue();
                }

            }
        }
        //没有  生成令牌    保存在Cookie中   写回浏览器
        String csessionid = UUID.randomUUID().toString().replaceAll("-", "");
        Cookie cookie = new Cookie(Constants.CSESSIONID,csessionid);
        //存活时间  关闭浏览器 就消失    -1    0 立即       >0  秒 60*60*24*7
        cookie.setMaxAge(-1);
        //路径
        cookie.setPath("/");
        response.addCookie(cookie);
        return csessionid;
    }
}
