package com.entity;

import org.springframework.stereotype.Component;
import java.util.*;

@Component("testEntity")  // 实体的注解 
public class TestEntity {  

	private String name;

	private List<String> names;
	
	private Demo demo;
	
	public Demo getDemo() {
		return demo;
	}

	public void setDemo(Demo demo) {
		this.demo = demo;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestEntity() {
	
	}

	public TestEntity(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestEntity [name=" + name + ", names=" + names + ", demo="
				+ demo + "]";
	}

}
