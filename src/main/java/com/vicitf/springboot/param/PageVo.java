package com.vicitf.springboot.param;

import java.util.List;

/**
 * 伪page
 * 
 * @author vicitf
 *
 * @param <T>
 */
public class PageVo<T> {
	private List<T> content;
	private boolean first;
	private boolean last;
	private int number; // 从0开始
	private int numberOfElements;
	private int size;
	private SortVo sort;
	private Long totalElements;
	private int totalPages;

	public PageVo(int number, int size) {
		this.number = number;
		this.size = size;
	}
	
	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public int getNumber() {
		return number;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public int getSize() {
		return size;
	}

	public SortVo getSort() {
		return sort;
	}

	public void setSort(SortVo sort) {
		this.sort = sort;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "PageVo [content=" + content + ", first=" + first + ", last="
				+ last + ", number=" + number + ", numberOfElements="
				+ numberOfElements + ", size=" + size + ", sort=" + sort
				+ ", totalElements=" + totalElements + ", totalPages="
				+ totalPages + "]";
	}

}
