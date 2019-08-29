package com.itheima.core.service.upload;

/**
 * @Auther: wanglei
 * @Date: 2019.07.29
 * @Description: com.itheima.service.upload
 * @version: 1.0
 */
public interface UploadService{
    public String uploadPic(byte[] pic,String name,long size) throws  Exception;
}
