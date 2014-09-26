/**
 * 
 */
package com.coderme.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.coderme.entity.Role;
import com.hnky.core.base.HibernateBaseDAO;
import com.hnky.core.pagenation.DataGridDto;

/**
 * @author zhang tengfei
 * 2014-8-19
 */
@Repository
public class RoleDAO extends HibernateBaseDAO<Role, Long> {

	@SuppressWarnings("unchecked")
	public List<Role> findByIds(List<Long> ids) {
		String hql = "from Role where id in (:ids)";
		Query q = getSession().createQuery(hql);
		q.setParameterList("ids", ids);
		return q.list();
	}
	
	public DataGridDto<Role> findAllByPage(int startIndex, int pageSize) {
		String hql = " from Role ";
		return findByPage(hql, null, startIndex, pageSize);
	}
}
