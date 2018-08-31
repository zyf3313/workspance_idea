/** 
 * <pre>项目名称:shiro_demo 
 * 文件名称:MyRealm.java 
 * 包名:com.jk.shiro 
 * 创建日期:2018年8月20日下午6:27:04 
 * Copyright (c) 2018, myangsh@sina.com All Rights Reserved.</pre> 
 */  
package com.jk.shiro;

import com.jk.entity.User;
import com.jk.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;


/** 
 * <pre>项目名称：shiro_demo    
 * 类名称：MyRealm    
 * 类描述：    
 * 创建人：Yangshy myangsh@sina.com    
 * 创建时间：2018年8月20日 下午6:27:04    
 * 修改人：Yangshy myangsh@sina.com     
 * 修改时间：2018年8月20日 下午6:27:04    
 * 修改备注：       
 * @version </pre>    
 */
public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String)token.getPrincipal();
		User user = userService.getUserByUserName(userName);
		if (user == null){
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getUserPassword(),this.getName());
		return simpleAuthenticationInfo;
	}

}
