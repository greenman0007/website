/**
 * 
 */
package com.coderme.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderme.entity.Article;
import com.coderme.service.ArticleService;
import com.hnky.core.util.SpringContextUtil;

/**
 * @author zhang tengfei
 * 2014-9-28
 */
public class PermaLinkFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String requestUri = httpRequest.getRequestURI();
		if (requestUri.startsWith(httpRequest.getContextPath())) {
			requestUri = requestUri.substring(httpRequest.getContextPath().length());
		}
		ArticleService articleService = (ArticleService) SpringContextUtil.getBean("articleService");
		Article article = articleService.findByPermalink(requestUri);
		if (null == article) {
//			RequestDispatcher rd = httpRequest.getRequestDispatcher(requestUri);
////			request.setAttribute("isPermLink", notPermLink);
//			rd.forward(request, response);
			httpResponse.sendRedirect(httpRequest.getRequestURI());
		} else {
			RequestDispatcher rd = httpRequest.getRequestDispatcher("/article/"+article.getId());
			rd.forward(httpRequest, httpResponse);  //提交至http://localhost:8080/article/{id}
			return;
		}
		chain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void destroy() {
		
	}

}
