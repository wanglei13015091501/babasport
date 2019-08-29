package com.itheima.common.upload;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

/**
 * @Auther: wanglei
 * @Date: 2019.07.29
 * @Description: com.itheima.common.upload
 * @version: 1.0
 */
public class FastDFSUtils {
    public static String uploadPic(byte[] pic,String name,long size) throws Exception {
        //全局设置Tracker的IP
        ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
        String path1 = resource.getClassLoader().getResource("fdfs_client.conf").getPath();
        ClientGlobal.init(path1);
        //连接Tracker
        TrackerClient trackerClient = new TrackerClient();
        //获取Stoage的地址
        TrackerServer trackerServer = trackerClient.getConnection();
        //连接Stoage的服务器
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);
        //上传图片到Stoage
        String ext = FilenameUtils.getExtension(name);
        NameValuePair[] meta_list = new NameValuePair[3];
        meta_list[0] = new NameValuePair("filename",name);
        meta_list[1] = new NameValuePair("fileext",ext);
        meta_list[2] = new NameValuePair("filesize",String.valueOf(size));
        //  group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
        String path = storageClient1.upload_file1(pic, ext, meta_list);
        //接收返回值（图片的路径）
        return path;
    }
}
