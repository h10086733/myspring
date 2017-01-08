package com.huqiyun.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * <code>{@link CharLimitFilter}</code>
 *
 * 拦截防止sql注入
 *
 * @author Administrator
 */
public class XssFilter implements Filter {
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException,
			ServletException {
			XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(
			(HttpServletRequest) request);
			filterChain.doFilter(xssRequest, response);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}