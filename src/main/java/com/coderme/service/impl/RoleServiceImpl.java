/**
 * 
 */
package com.coderme.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderme.dao.RoleDAO;
import com.coderme.entity.Permission;
import com.coderme.entity.Role;
import com.coderme.service.PermissionService;
import com.coderme.service.RoleService;
import com.hnky.core.pagenation.DataGridDto;

/**
 * @author zhang tengfei
 * 2014-8-19
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDAO roleDAO;
	@Resource
	private PermissionService permissionService;
	
	@Override
	public List<Role> findByIds(List<Long> ids) {
		return roleDAO.findByIds(ids);
	}

	@Override
	public List<Role> findAll() {
		String hql = " from Role ";
		return roleDAO.list(hql, null);
	}

	@Override
	@Transactional
	public void save(Role role) {
		roleDAO.add(role);
	}

	@Override
	public Role getById(Long id) {
		return roleDAO.get(id);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		roleDAO.delete(id);
	}

	@Override
	@Transactional
	public void update(Role role) {
		roleDAO.update(role);
	}

	@Override
	@Transactional
	public void saveRoleAssign(Role role) {
		Role roleReal = roleDAO.get(role.getId());
		if (null != role.getPermIds()) {
			String[] ids = role.getPermIds().split(",");
			List<Long> idLongs = new ArrayList<Long>();
			for (String id : ids) {
				idLongs.add(Long.valueOf(id));
			}
			List<Permission> permissions = permissionService.findByIds(idLongs);
			roleReal.setPermissions(permissions);
			roleDAO.update(roleReal);
		}
	}

	@Override
	public DataGridDto<Role> findAllByPage(int startIndex, int pageSize) {
		return roleDAO.findAllByPage(startIndex, pageSize);
	}

}
