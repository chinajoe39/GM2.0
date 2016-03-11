package com.taotao.pojo;

import java.util.List;

public class EasyUIListResult {

	/** 总条数 */
	private long total;
	
	/** 页码 */
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
