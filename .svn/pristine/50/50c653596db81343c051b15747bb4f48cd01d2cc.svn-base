package com.dp.intelligentplant.util;

import java.util.ArrayList;
import java.util.List;

public class PageVO<T> {

	private static final int DEFAULT_INDEX = 1;
	
	private static final int DEFAULT_SIZE = 20;
	
	/** 页号 */
	private int pageIndex = DEFAULT_INDEX;
	
	/** 每页记录数 */
	private int pageSize = DEFAULT_SIZE;
	
	/** 总的记录数 */
	private long itemsCount = -1;
	
	/** 分页结果集 */
	private List<T> data = new ArrayList<T>();
	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(long itemsCount) {
		this.itemsCount = itemsCount;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override  
	public String toString() {
		return "PageResult [Rows=" + data + ", Total=" + itemsCount + "]";
	}
	
}
