package com.entity;

import java.util.*;

public class DemoData {
	
	private int total;
	
	private List<Demo> rows ;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Demo> getRows() {
		return rows;
	}

	public void setRows(List<Demo> rows) {
		this.rows = rows;
	}

	public DemoData() {
		
	}

	public DemoData(int total, List<Demo> rows) {
	
		this.total = total;
		this.rows = rows;
	}
	
}
