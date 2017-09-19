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

public class RedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    @Autowired
    private static JedisConnectionFactory jedisConnectionFactory;

    private final String id;


    /**
     * The {@code ReadWriteLock}.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache(final String id){
        if(id==null){
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        logger.debug("MybatisReidsCache:id="+id);
        this.id = id;
    }



    public String getId() {
        return id;
    }

    public void putObject(Object key, Object value) {
        JedisConnection connection = null;
        try
        {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value);
            connection = jedisConnectionFactory.getConnection();

            byte[] keybyte= SerializableUtil.serialize(key);
            byte[] valuebyte=SerializableUtil.serialize(value);
            connection.set(keybyte, valuebyte);

        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public Object getObject(Object key) {
        Object result = null;
        JedisConnection connection = null;
        try{
            connection = jedisConnectionFactory.getConnection();
            byte[] value = connection.get(SerializableUtil.serialize(key));
            if(value!=null && value.length>0) {
                result = SerializableUtil.unserizlize(value);
            }

        }catch(JedisConnectionException ex){
            ex.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
        return result;
    }

    public Object removeObject(Object key) {
        JedisConnection connection = null;
        Object result = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            result =connection.expire(SerializableUtil.serialize(key), 0);
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    public void clear() {
        JedisConnection connection = null;
        try{
            connection = jedisConnectionFactory.getConnection();
            connection.flushDb();
        }catch(JedisConnectionException ex){
            ex.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
    }

    public int getSize() {
        int result = 0;
        JedisConnection connection = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }


}
