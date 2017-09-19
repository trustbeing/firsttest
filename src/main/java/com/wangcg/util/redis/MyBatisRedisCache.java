package com.wangcg.util.redis;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyBatisRedisCache implements Cache {
	private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

	private final String id;

	public MyBatisRedisCache(final String id){
		if(id==null){
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		logger.debug("MybatisReidsCache:id="+id);
		this.id = id;
	}

	/**
	 * The {@code ReadWriteLock}.
	 */
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


	public String getId() {
		return id;
	}

	public void putObject(Object key, Object value) {
		try{
			RedisCache.putObject(key,value);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public Object getObject(Object key) {
		Object result = null;
		try{
			result  = RedisCache.getObject(key);

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	public Object removeObject(Object key) {
		Object result = null;
		try {
			result  = RedisCache.removeObject(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void clear() {
		JedisConnection connection = null;
		try{
			RedisCache.clear();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public int getSize() {
		int result = 0;
		try{
			result = RedisCache.getSize();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	public ReadWriteLock getReadWriteLock() {
		return this.readWriteLock;
	}
}
