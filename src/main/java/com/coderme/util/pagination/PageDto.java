/**
 * 
 */
package com.coderme.util.pagination;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang tengfei
 * 2014-9-26
 */
public class PageDto<T> implements Serializable {

	private static final long serialVersionUID = 6814450247787222103L;
	
	private int total;
	
	private String currentPage;
	
	private Long totalPages;
	
	private Integer pageSize = 10;
	
	private List<T> rows = new ArrayList<T>();

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
