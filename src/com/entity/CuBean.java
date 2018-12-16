package com.entity;

import java.util.*;
/*
 * 封装 国家和人口的数据 
 */
public class CuBean {

	private List<String> names = new ArrayList<String>();
	
	private List<Integer> year11 = new ArrayList<Integer>();
	
	private List<Integer> year12 = new ArrayList<Integer>();

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public List<Integer> getYear11() {
		return year11;
	}

	public void setYear11(List<Integer> year11) {
		this.year11 = year11;
	}

	public List<Integer> getYear12() {
		return year12;
	}

	public void setYear12(List<Integer> year12) {
		this.year12 = year12;
	}

	public CuBean() {
	
	}

	public CuBean(List<String> names, List<Integer> year11, List<Integer> year12) {
		this.names = names;
		this.year11 = year11;
		this.year12 = year12;
	}
	
}
