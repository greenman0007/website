package com.coderme.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderme.entity.Article;
import com.coderme.service.ArticleService;
import com.hnky.core.util.SpringContextUtil;

public class PermaLinkServlet extends HttpServlet {

	private static final long serialVersionUID = -2921592261760866972L;
	
	private static final String notPermLink = "notPermLink";
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUri = request.getRequestURI();
		if (requestUri.startsWith(request.getContextPath())) {
			requestUri = requestUri.substring(request.getContextPath().length());
		}
		if (notPermLink.equals(request.getAttribute("isPermLink"))) {
			if ("/".equals(requestUri)) {
				response.sendRedirect(request.getContextPath()+"/index.html");
			} else {
				File file = new File(request.getContextPath()+"/"+requestUri);
				if (file.exists()) {
					response.sendRedirect(request.getContextPath()+"/"+requestUri);
				} else {
					//TODO 404 NotFound
					return;
				}
			}
			return;
		}
		ArticleService articleService = (ArticleService) SpringContextUtil.getBean("articleService");
		Article article = articleService.findByPermalink(requestUri);
		if (null == article) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(requestUri);
			request.setAttribute("isPermLink", notPermLink);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/article/"+article.getId());
			rd.forward(request, response);  //提交至http://localhost:8080/article/{id}
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
