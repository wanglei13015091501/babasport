package com.itheima.core.service;/**
 * @类名:SessionProviderImpl
 * @描述:TODO
 * @作者:wanglei
 * @日期:19/9/19 下午9:41
 * @版本:1.0
 **/

import com.itheima.common.redis.RedisUtil;
import com.itheima.common.web.Constants;
import com.itheima.core.service.buyer.SessionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 *@类名:SessionProviderImpl
 *@描述:TODO
 *@作者:wanglei
 *@日期:19/9/19 下午9:41
 *@版本:1.0
 **/
@Service("sessionProvider")
public class SessionProviderImpl implements SessionProvider {

    @Autowired
    private RedisUtil redisUtil;
    //可更改存活时间
    private Integer exp = 30;

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    /**
     *保存用户到 Redis 中
     * @author wanglei
     * @date 19/9/19
     * @param [key(令牌 csessionid 32位长度的字符串), value(用户名)]
     * @return void
     */
    @Override
    public void setAttributeForUsername(String key, String value) {
        redisUtil.set(key+":"+Constants.USER_NAME,value);
        redisUtil.expire(key + ":"+Constants.USER_NAME,60*exp);
    }

    /**
     *取出用户名从 Redis 中
     * @author wanglei
     * @date 19/9/19
     * @param [key]
     * @return java.lang.String
     */
    @Override
    public String getAttributeForUsername(String key) {
        String username = redisUtil.get(key + ":" + Constants.USER_NAME).toString();
        if (username!=null){
            //存活时间是 30 分钟默认值
            redisUtil.expire(key+":"+Constants.USER_NAME,60*exp);
            return  username;
        }else{
            return null;
        }
    }


}
