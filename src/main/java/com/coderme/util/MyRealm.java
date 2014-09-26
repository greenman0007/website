/**
 * 
 */
package com.coderme.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.coderme.entity.User;
import com.coderme.service.UserService;

/**
 * 自定义的指定Shiro验证用户登录的类 
 * @author zhang tengfei
 * 2014-8-13
 */
public class MyRealm extends AuthorizingRealm {
	
	private static final String OR_OPERATOR = " or ";  
	private static final String AND_OPERATOR = " and ";  
	private static final String NOT_OPERATOR = "not ";  
	
	private static Logger logger = LoggerFactory.getLogger(MyRealm.class);
	@Resource
    private UserService userService;
	
	private static Map<Long, String> roleMap = new HashMap<Long, String>();
	
	private static Map<Long, List<String>> rolePermsMap = new HashMap<Long, List<String>>();
	@Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
		return null;
    }  
  
    /** 
     * 验证当前登录的Subject 
     * @see 经测试:本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {  
        //获取基于用户名和密码的令牌  
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的  
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
        logger.debug("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
		User user = userService.findUserByName(token.getUsername());
		if (null != user) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(
					user.getUsername(), user.getPassword(), this.getName());
			this.setSession("user", user);
			return authcInfo;
		} else {
			return null;
		}
       
    }  
      
      
    /** 
     * 将一些数据放到ShiroSession中,以便于其它地方使用 
     * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
     */  
    private void setSession(Object key, Object value){  
        Subject currentUser = SecurityUtils.getSubject();  
        if(null != currentUser){  
            Session session = currentUser.getSession();  
            logger.info("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
            logger.info("session.getId()[" + session.getId() + "]");  
            logger.info("session.getHost()[" + session.getHost() + "]");  
            if(null != session){  
                session.setAttribute(key, value);  
            }  
        }  
    } 
    
    /** 
     * 支持or and not 关键词  不支持and or混用 
     * 实现如showcase:tree:(create|update|delete)这种语法,jsp标签：<shiro:hasPermission name="showcase:tree:create or showcase:tree:update or showcase:tree:delete">
     * @param principals 
     * @param permission 
     * @return 
     */ 
    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {  
        if(permission.contains(OR_OPERATOR)) {  
            String[] permissions = permission.split(OR_OPERATOR);  
            for(String orPermission : permissions) {  
                if(isPermittedWithNotOperator(principals, orPermission)) {  
                    return true;  
                }  
            }  
            return false;  
        } else if(permission.contains(AND_OPERATOR)) {  
            String[] permissions = permission.split(AND_OPERATOR);  
            for(String orPermission : permissions) {  
                if(!isPermittedWithNotOperator(principals, orPermission)) {  
                    return false;  
                }  
            }  
            return true;  
        } else {  
            return isPermittedWithNotOperator(principals, permission);  
        }  
    }  
      
    private boolean isPermittedWithNotOperator(PrincipalCollection principals, String permission) {  
        if(permission.startsWith(NOT_OPERATOR)) {  
            return !super.isPermitted(principals, permission.substring(NOT_OPERATOR.length()));  
        } else {  
            return super.isPermitted(principals, permission);  
        }  
    }

	public static Map<Long, String> getRoleMap() {
		return roleMap;
	}

	public static void setRoleMap(Map<Long, String> roleMap) {
		MyRealm.roleMap = roleMap;
	}

	public static Map<Long, List<String>> getRolePermsMap() {
		return rolePermsMap;
	}

	public static void setRolePermsMap(Map<Long, List<String>> rolePermsMap) {
		MyRealm.rolePermsMap = rolePermsMap;
	}
}
