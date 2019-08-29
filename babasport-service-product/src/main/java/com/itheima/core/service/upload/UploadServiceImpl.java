package com.itheima.core.service.upload;

import com.itheima.common.upload.FastDFSUtils;
import org.springframework.stereotype.Service;

/**
 * @Auther: wanglei
 * @Date: 2019.07.29
 * @Description: com.itheima.service.upload
 * @version: 1.0
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {


    @Override
    public String uploadPic(byte[] pic,String name,long size) throws Exception {
        return FastDFSUtils.uploadPic(pic, name, size);
    }
}
