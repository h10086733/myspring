package com.huqiyun.cache;

public interface ICacheManager {

	public abstract void putObject(String code, Object obj, int time);

	public abstract void removeObject(String code);

	public abstract Object getObject(String code);

	public abstract void removeAllObject();

}