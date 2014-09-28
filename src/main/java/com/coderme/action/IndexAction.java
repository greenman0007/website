/**
 * 
 */
package com.coderme.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderme.entity.Article;
import com.coderme.service.ArticleService;
import com.coderme.util.pagination.PageDto;
import com.hnky.core.pagenation.DataGridDto;

/**
 * @author zhang tengfei
 * 2014-9-26
 */
@RequestMapping(value="/index")
@Controller
public class IndexAction {

	@Resource
	private ArticleService articleService;
	
	/**
	 * 首页
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		String pageNo = request.getParameter("pageNo");
		PageDto<Article> pageDto = new PageDto<Article>();
		pageDto.setCurrentPage(null==pageNo?"1":pageNo);
		
		DataGridDto<Article> dataGridDto = articleService.findByPage(null==pageNo?1:Integer.valueOf(request.getParameter("pageNo")), 10);
		
		pageDto.setTotal(dataGridDto.getTotal());
		pageDto.setTotalPages((long) (dataGridDto.getTotal()/pageDto.getPageSize()+1));
		pageDto.setRows(dataGridDto.getRows());
		
		model.addAttribute("pageDto", pageDto);
		return "index";
	}
}
