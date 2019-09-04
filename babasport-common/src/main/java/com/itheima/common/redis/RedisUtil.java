package com.itheima.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Map;


/**
 * @Auther: wanglei
 * @Date: 2019.08.26
 * @Description: com.itheima.common.redis
 * @version: 1.0
 */
@Service
public class RedisUtil {

    @Autowired(required = false)
    private ShardedJedisPool shardedJedisPool;

    // 封装通用逻辑
    private <T> T execute(Function<ShardedJedis, T> fun) {
        ShardedJedis shardedJedis = null;
        try {
            // 从连接池中获取到jedis分片对象
            shardedJedis  = shardedJedisPool.getResource();
            return fun.callBack(shardedJedis);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != shardedJedis) {
                // 关闭，检测连接是否有效，有效则放回到连接池中，无效则重置状态
                shardedJedis.close();
            }
        }
        return null;
    }

    /**
     * 执行set方法
     *
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callBack(ShardedJedis shardedJedis) {
                return shardedJedis.set(key, value);
            }
        });
    }

    /**
     * 执行set方法，并设置生存时间
     *
     * @param key
     * @param value
     * @param seconds
     *            时间，单位是秒
     * @return
     */
    public String set(final String key, final String value,
                      final Integer seconds) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callBack(ShardedJedis shardedJedis) {
                String str = shardedJedis.set(key, value);
                shardedJedis.expire(key, seconds);
                return str;
            }
        });
    }

    /**
     * 执行get方法
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        return this.execute(new Function<ShardedJedis, String>() {
            @Override
            public String callBack(ShardedJedis shardedJedis) {
                return shardedJedis.get(key);
            }
        });
    }

    /**
     * 删除key
     *
     * @param key
     * @return
     */
    public Long del(final String key) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callBack(ShardedJedis shardedJedis) {
                return shardedJedis.del(key);
            }
        });
    }

    /**
     * 设置生存时间
     *
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(final String key, final int seconds) {
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callBack(ShardedJedis shardedJedis) {
                return shardedJedis.expire(key, seconds);
            }
        });
    }

    public Long incr(final String key){
        return this.execute(new Function<ShardedJedis, Long>() {
            @Override
            public Long callBack(ShardedJedis shardedJedis) {
                return shardedJedis.incr(key);
            }
        });
    }

    public Long hset(final String key,final String field,final String value){
        return this.execute(new Function<ShardedJedis,Long>() {
            @Override
            public Long callBack(ShardedJedis shardedJedis) {
                return shardedJedis.hset(key,field,value);
            }
        });
    }

    public Map<String, String> hgetAll(final String key){
        return this.execute(new Function<ShardedJedis,Map<String,String>>() {
            @Override
            public Map<String, String> callBack(ShardedJedis shardedJedis) {
                return shardedJedis.hgetAll(key);
            }
        });
    }

}
