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

	public DataGridDto<Article> findByPage(int startIndex, int pageSize);
}
