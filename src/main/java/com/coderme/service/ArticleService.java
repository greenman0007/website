/**
 * 
 */
package com.coderme.service;

import com.coderme.entity.Article;
import com.hnky.core.pagenation.DataGridDto;

/**
 * @author zhang tengfei
 * 2014-9-26
 */
public interface ArticleService {

	/**
	 * 分页查询
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public DataGridDto<Article> findByPage(int startIndex, int pageSize);
	/**
	 * 根据永久链接查询
	 * @param permalink
	 * @return
	 */
	public Article findByPermalink(String permalink);
	
	public Article get(Long id);
}
