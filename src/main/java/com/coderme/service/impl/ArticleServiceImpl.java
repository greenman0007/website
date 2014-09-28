/**
 * 
 */
package com.coderme.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.coderme.dao.ArticleDAO;
import com.coderme.entity.Article;
import com.coderme.service.ArticleService;
import com.hnky.core.pagenation.DataGridDto;

/**
 * @author zhang tengfei
 * 2014-9-26
 */
@Service(value="articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleDAO articleDAO;
	
	@Override
	public DataGridDto<Article> findByPage(int startIndex, int pageSize) {
		return articleDAO.findByPage(startIndex, pageSize);
	}

	@Override
	public Article findByPermalink(String permalink) {
		return articleDAO.findByPermalink(permalink);
	}

	@Override
	public Article get(Long id) {
		return articleDAO.get(id);
	}

}
