package com.huqiyun.cache.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.huqiyun.cache.ICacheManager;

@Component("mapCache")
public class CacheManagerMapImpl implements ICacheManager {
	private static class CacheEntry{
		//添加对象时间
		private long putTime;
		//存活时长
		private long liveTime;
		//存储对象
		private Object obj;
		public CacheEntry(long time,Object obj) {
			this.putTime=System.currentTimeMillis();
			this.liveTime=time*1000;
			this.obj=obj;
		}
		public long getPutTime() {
			return putTime;
		}
		public long getLiveTime() {
			return liveTime;
		}
		public Object getObj() {
			return obj;
		}
	}
    private Map<String, CacheEntry> newsCache;  
    private AtomicInteger length=new AtomicInteger(0);
    
    public CacheManagerMapImpl() {
        newsCache = new ConcurrentHashMap<String, CacheManagerMapImpl.CacheEntry>();
    }  

    @Override
	public void putObject(String code,Object obj,int time) {
    	if(length.intValue()>1000){
    		removeAllObject();
    	}
    	Object old=newsCache.put(code, new CacheEntry(time,obj));
    	//覆盖对象时容量不变   新增时，length+1
    	if(old==null){
    		length.addAndGet(1);
    	}
    }  
  
    /* (non-Javadoc)
	 * @see com.paic.mall.oscache.ICacheManager#removeObject(java.lang.String)
	 */
    @Override
	public void removeObject(String code) {
       Object old=newsCache.remove(code);
   		//对象不存在时容量不变   删除存在key，length-1
       if(old!=null){
    	   length.addAndGet(-1);
       }
    }  
  
    /* (non-Javadoc)
	 * @see com.paic.mall.oscache.ICacheManager#getObject(java.lang.String)
	 */
    @Override
	public Object getObject(String code) {
    	try {
			CacheEntry ce=newsCache.get(code);  
			if(ce==null){
				return null;
			}
			//移除过期对象
			if((System.currentTimeMillis()-ce.getPutTime())>ce.getLiveTime()){
				removeObject(code);
				return null;
			}else{
				return ce.getObj();
			}
		} catch (Exception e) {
			return null;
		}
    }  
    /* (non-Javadoc)
	 * @see com.paic.mall.oscache.ICacheManager#removeAllObject()
	 */
    @Override
	public void removeAllObject() {  
    	newsCache.clear();
    	length.set(0);
    }  
}  
