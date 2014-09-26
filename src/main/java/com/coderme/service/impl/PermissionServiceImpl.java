package com.coderme.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderme.Constants;
import com.coderme.dao.PermissionDAO;
import com.coderme.entity.Permission;
import com.coderme.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Resource
	private PermissionDAO permissionDAO;
	
	@Override
	public List<Permission> findAll() {
		String hql = "from Permission ";
		return permissionDAO.list(hql, null);
	}

	@Override
	public Permission getById(Long id) {
		return permissionDAO.get(id);
	}

	@Override
	@Transactional
	public void update(Permission permission) {
		permissionDAO.update(permission);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		permissionDAO.delete(id);
	}

	@Override
	@Transactional
	public void save(Permission permission) {
		if (0 != permission.getParentId()) {
			permission.setRootNode(0);
		} else {
			permission.setRootNode(1);
		}
		if (Constants.PermissionType.button.getInfo().equals(permission.getType())) {
			permission.setIsLeaf(1);
		} else {
			permission.setIsLeaf(0);
		}
		permissionDAO.add(permission);
	}

	@Override
	public List<Permission> findByIds(List<Long> ids) {
		return permissionDAO.findByIds(ids);
	}

}
