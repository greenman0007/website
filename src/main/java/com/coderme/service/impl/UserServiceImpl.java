/**
 * 
 */
package com.coderme.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderme.dao.UserDAO;
import com.coderme.entity.User;
import com.coderme.service.UserService;
import com.hnky.core.util.MD5Encoder;

/**
 * @author zhang tengfei
 * 2014-8-7
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDAO userDAO;
	@Resource
	private MD5Encoder mD5Encoder;
	
	@Override
	public User findUserByName(String userName) {
		return userDAO.findUserByName(userName);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		user.setPassword(mD5Encoder.encodePassword(user.getPassword()));
		userDAO.add(user);
	}

	@Override
	@Transactional
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userDAO.delete(user);
	}

}
