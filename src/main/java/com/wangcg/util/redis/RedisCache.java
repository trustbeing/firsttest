package com.wangcg.util.redis;

import com.wangcg.util.SerializableUtil;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache{

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    @Autowired
    private static JedisConnectionFactory jedisConnectionFactory;


    public static void putObject(Object key, Object value) throws JedisConnectionException {
        JedisConnection connection = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            connection.set(SerializableUtil.serialize(key), SerializableUtil.serialize(value));

        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
    }


    public static Object getObject(Object key) throws JedisConnectionException{
        Object result = null;
        JedisConnection connection = null;
        try{
            connection = jedisConnectionFactory.getConnection();
            byte[] value = connection.get(SerializableUtil.serialize(key));
            if(value!=null && value.length>0) {
                result = SerializableUtil.unserizlize(value);
            }
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
        return result;
    }

    public static Object removeObject(Object key) throws JedisConnectionException{
        JedisConnection connection = null;
        Object result = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            result =connection.expire(SerializableUtil.serialize(key), 0);
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    public static void clear() throws JedisConnectionException {
        JedisConnection connection = null;
        try{
            connection = jedisConnectionFactory.getConnection();
            connection.flushDb();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
    }

    public static int getSize() throws JedisConnectionException {
        int result = 0;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }


}
