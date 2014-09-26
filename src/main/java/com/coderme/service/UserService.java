/**
 * 
 */
package com.coderme.service;

import java.util.List;

import com.coderme.entity.User;

/**
 * @author zhang tengfei
 * 2014-8-7
 */
public interface UserService {

	public User findUserByName(String userName);
	
	public void saveUser(User user);
	
	public void update(User user);
	
	public List<User> findAll();
	
	public void deleteUser(User user);
}
