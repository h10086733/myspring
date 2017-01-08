package com.huqiyun.cache.impl;
import java.net.URL;

import javax.annotation.PreDestroy;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.huqiyun.cache.ICacheManager;

@Component("ehCache")
public class CacheManagerEHCacheImpl implements ICacheManager {
	static Logger logger = Logger.getLogger(CacheManagerEHCacheImpl.class);
	private CacheManager manager;
	private Cache cache;
	public  CacheManagerEHCacheImpl() {
		try {
			URL url=getClass().getResource("/cache.xml");
			manager=CacheManager.create(url);
//			manager=CacheManager.create("cache.xml");
			cache=manager.getCache("lufaxCache");
		} catch (CacheException e) {
			logger.fatal("CacheManagerEHCacheImpl.cachemanagereh",e);
		}
	}
	@PreDestroy
	public void destroy(){
		try {
			manager.shutdown();
		} catch (Exception e) {
			logger.warn("CacheManagerEHCacheImpl.destroy", e);
		}
	}
	public void putObject(String code, Object obj) {
		Element element=new Element(code,obj);
		try {
			cache.put(element);
		} catch (RuntimeException e) {
			logger.warn("CacheManagerEHCacheImpl.putObject",e);
		}
	}
	@Override
	public void removeObject(String code) {
		try {
			cache.remove(code);
		} catch (RuntimeException e) {
			logger.warn("CacheManagerEHCacheImpl.removeObject",e);
		}
	}

	@Override
	public Object getObject(String code) {
		Element element=null;
		try {
			element=cache.get(code);
		} catch (RuntimeException e) {
			logger.warn("CacheManagerEHCacheImpl.getObject",e);
		}
		if(element==null||element.isExpired()){
			return null;
		}
		return element.getObjectValue();
	}

	@Override
	public void removeAllObject() {
		try {
			cache.removeAll();
		} catch (RuntimeException e) {
			logger.warn("CacheManagerEHCacheImpl.removeAllObject",e);
		}
	}
	@Override
	public void putObject(String code, Object obj, int time) {
		Element element=new Element(code, obj,time,time);
		try {
			cache.put(element);
		} catch (RuntimeException e) {
			logger.warn("CacheManagerEHCacheImpl.putObject",e);
		}
	}
	
}
