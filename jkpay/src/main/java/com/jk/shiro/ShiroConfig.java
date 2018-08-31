/** 
 * <pre>项目名称:shiro_demo 
 * 文件名称:ShiroConfig.java 
 * 包名:com.jk.shiro 
 * 创建日期:2018年8月20日下午5:46:50 
 * Copyright (c) 2018, myangsh@sina.com All Rights Reserved.</pre> 
 */
package com.jk.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * <pre>
 * 项目名称：shiro_demo    
 * 类名称：ShiroConfig    
 * 类描述：    
 * 创建人：Yangshy myangsh@sina.com    
 * 创建时间：2018年8月20日 下午5:46:50    
 * 修改人：Yangshy myangsh@sina.com     
 * 修改时间：2018年8月20日 下午5:46:50    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Configuration
public class ShiroConfig {

	 @Bean(name = "lifecycleBeanPostProcessor")
	    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	        return new LifecycleBeanPostProcessor();
	    }
	
	
	@Bean
	public SecurityManager securityManager() {

		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		return securityManager;

	}
	
	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public MyRealm myShiroRealm(){
		MyRealm myShiroRealm = new MyRealm();
		return myShiroRealm;

	}


	
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {

		System.out.println("ShiroConfiguration.shirFilter()");

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		// 必须设置 SecurityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 拦截器.
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

		// 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了

		filterChainDefinitionMap.put("/logout", "logout");
		filterChainDefinitionMap.put("/toLogin", "anon");
		filterChainDefinitionMap.put("/jkpay/account**", "anon");
		filterChainDefinitionMap.put("/login/css/**", "anon");
		filterChainDefinitionMap.put("/login/images/**", "anon");
		filterChainDefinitionMap.put("/login/js/**", "anon");
		filterChainDefinitionMap.put("/gateWay", "anon");
		filterChainDefinitionMap.put("/passwordVerify", "anon");
		filterChainDefinitionMap.put("/toNotifyurl", "anon");
		filterChainDefinitionMap.put("/toPayCenter", "anon");
		filterChainDefinitionMap.put("/**", "authc");
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");
		// 未授权界面;
		//shiroFilterFactoryBean.setUnauthorizedUrl("/warning");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilterFactoryBean;

	}
	



}
