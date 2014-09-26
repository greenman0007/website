/**
 * 
 */
package com.coderme.service;

import java.util.List;

import com.coderme.entity.Role;
import com.hnky.core.pagenation.DataGridDto;

/**
 * @author zhang tengfei
 * 2014-8-19
 */
public interface RoleService {

	public List<Role> findByIds(List<Long> ids);
	
	public List<Role> findAll();

	public void save(Role role);

	public Role getById(Long id);

	public void deleteById(Long id);

	public void update(Role role);
	
	public void saveRoleAssign(Role role);
	
	public DataGridDto<Role> findAllByPage(int startIndex, int pageSize);
}
