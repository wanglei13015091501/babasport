package com.itheima.core.service.buyer;


/**
 * @类名:SessionProvider
 * @描述:TODO
 * @作者:wanglei
 * @日期:19/9/19 下午9:58
 * @版本:1.0
 **/
public interface SessionProvider {
    //保存用户名到Redis中
    // Key : 令牌   csessionid 32位长度的字符串
    // Value : 用户名
    public void setAttributeForUsername(String key,String value);

    //获取用户名从redis中
    public String getAttributeForUsername(String key);

}
