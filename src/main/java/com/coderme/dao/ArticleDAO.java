/**
 * 
 */
package com.coderme.dao;

import org.springframework.stereotype.Repository;

import com.coderme.entity.Article;
import com.hnky.core.base.HibernateBaseDAO;
import com.hnky.core.pagenation.DataGridDto;

/**
 * @author zhang tengfei
 * 2014-9-26
 */
@Repository
public class ArticleDAO extends HibernateBaseDAO<Article, Long> {

	public DataGridDto<Article> findByPage(int startIndex, int pageSize) {
		String hql = "from Article";
		return super.findByPage(hql, null, startIndex, pageSize);
	}
	/**
	 * 根据永久链接查询
	 * @param permalink
	 * @return
	 */
	public Article findByPermalink(String permalink){
		String hql = "from Article where articlePermalink=?";
		return (Article) queryByHql(hql, new String[]{permalink});
	}
}
