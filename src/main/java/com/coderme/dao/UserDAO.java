/**
 * 
 */
package com.coderme.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.coderme.entity.User;
import com.hnky.core.base.HibernateBaseDAO;

/**
 * @author zhang tengfei
 * 2014-8-7
 */
@Repository
public class UserDAO extends HibernateBaseDAO<User, Integer>{

	public User findUserByName(String userName) {
		String hql = " from User where username=?";
		return (User) queryByHql(hql, new String[]{userName});
	}
	
	public List<User> findAll() {
		String hql = " from User ";
		return list(hql, null);
	}
}
