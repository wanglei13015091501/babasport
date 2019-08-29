package com.itheima.core.controller;

import com.google.common.collect.Lists;
import com.itheima.common.web.Constants;
import com.itheima.core.service.upload.UploadService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 上传图片
 * @author lx
 *
 */
@Controller
public class UploadController {

	@Autowired
	private UploadService uploadService;

	//上传单张图片
	@RequestMapping(value = "/upload/uploadPic.do")
	public void uploadPic(MultipartFile pic,HttpServletRequest request
			,HttpServletResponse resopnse) throws Exception{
		
		System.out.println(pic.getOriginalFilename());
		//分布式文件系统中FastDFS
		//String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		
		//String path = "/upload/" + UUID.randomUUID().toString() + "." + ext;
		//上传到FastDFS并返回一个路径
		String path = uploadService.uploadPic(pic.getBytes(),pic.getOriginalFilename(),pic.getSize());

		//全路径
		//String url = request.getSession().getServletContext().getRealPath(path);
		String url = Constants.IMG_URL+path;

		//保存图片 到指定位置
		//pic.transferTo(new File(url));
		
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		String json = jo.toString();
		//回调图片
		resopnse.setContentType("application/json;charset=UTF-8");
		resopnse.getWriter().write(json);
	}

    /**
     * 上传多张图片
     * @param pics
     * @return
     * @throws Exception
     */
	@RequestMapping("/upload/uploadPics.do")
	@ResponseBody
	public List<String> uploadPic(@RequestParam(required = false)MultipartFile[] pics) throws Exception {
 		//创建url集合
		List<String> urlList = Lists.newArrayList();
		for (MultipartFile file : pics) {
			String path = uploadService.uploadPic(file.getBytes(),file.getOriginalFilename(),file.getSize());
		    String url = Constants.IMG_URL+path;
		    urlList.add(url);
		}

		return urlList;
	}

	@RequestMapping
	public void uploadFck(HttpServletRequest request,HttpServletResponse response) throws Exception {
		MultipartRequest mr = (MultipartRequest) request;
		Map<String, MultipartFile> fileMap = mr.getFileMap();
		Set<Map.Entry<String, MultipartFile>> entries = fileMap.entrySet();
		for (Map.Entry<String, MultipartFile> entry : entries) {
			MultipartFile pic = entry.getValue();
			String path = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
 			String url = Constants.IMG_URL+path;

 			JSONObject jsonObject = new JSONObject();
 			jsonObject.put("url",url);
 			jsonObject.put("error",0);

 			response.setContentType("application/json;charset=UTF-8");
 			response.getWriter().print(jsonObject.toString());
		}
	}
}
