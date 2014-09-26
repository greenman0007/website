/**
 * 
 */
package com.coderme.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.coderme.entity.Permission;
import com.hnky.core.base.HibernateBaseDAO;

/**
 * @author zhang tengfei
 * 2014-8-19
 */
@Repository
public class PermissionDAO extends HibernateBaseDAO<Permission, Long> {

	@SuppressWarnings("unchecked")
	public List<Permission> findByIds(List<Long> ids) {
		String hql = "from Permission where id in (:ids)";
		Query q = getSession().createQuery(hql);
		q.setParameterList("ids", ids);
		return q.list();
	}
}
