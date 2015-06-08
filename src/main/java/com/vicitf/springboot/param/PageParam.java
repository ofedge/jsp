package com.vicitf.springboot.param;

import java.util.List;

/**
 * 分页请求参数
 * 
 * @author vicitf
 *
 */
public class PageParam {
	private int page;
	private int nums;
	private List<PropertyVo> param;
	private SortVo sort;
	
	public PageParam(int page, int nums) {
		this.page = page;
		this.nums = nums;
	}

	public PageParam(int page, int nums, List<PropertyVo> param) {
		this.page = page;
		this.nums = nums;
		this.param = param;
	}

	public PageParam(int page, int nums, SortVo sort) {
		this.page = page;
		this.nums = nums;
		this.sort = sort;
	}

	public PageParam(int page, int nums, List<PropertyVo> param, SortVo sort) {
		this.page = page;
		this.nums = nums;
		this.param = param;
		this.sort = sort;
	}

	public int getPage() {
		return page;
	}

	public int getNums() {
		return nums;
	}

	public List<PropertyVo> getParam() {
		return param;
	}

	public SortVo getSort() {
		return sort;
	}

	@Override
	public String toString() {
		return "PageParam [page=" + page + ", nums=" + nums + ", param="
				+ param + ", sort=" + sort + "]";
	}

}
