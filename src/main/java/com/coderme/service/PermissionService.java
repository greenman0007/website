/**
 * 
 */
package com.coderme.service;

import java.util.List;

import com.coderme.entity.Permission;

/**
 * @author zhang tengfei
 * 2014-8-19
 */
public interface PermissionService {

	public Permission getById(Long id);
	
	public List<Permission> findAll();
	
	public void update(Permission permission);
	
	public void delete(Long id) ;
	
	public void save(Permission permission);
	
	public List<Permission> findByIds(List<Long> ids);
}
