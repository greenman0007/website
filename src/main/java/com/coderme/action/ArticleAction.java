/**
 * 
 */
package com.coderme.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderme.entity.Article;
import com.coderme.service.ArticleService;

/**
 * @author zhang tengfei
 * 2014-9-28
 */
@Controller
@RequestMapping(value="/article")
public class ArticleAction {
	
	@Resource
	private ArticleService articleService;

	/**
	 * 某一篇文章
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String query(Model model, @PathVariable Long id) {
		Article article = articleService.get(id);
		model.addAttribute("article", article);
		return "article";
	}
}
