package com.entity;

import java.util.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.entity.Demo;

public class UsersVo {
	
	@NotNull(message="用户编号不能为空！")
	private Integer id;
	
	@NotEmpty(message="用户名称不能为空！")
	@Size(min=3,max=6)
	private String name;
	
	private int did;
	
	private List<String> slist;

	private Demo demo;
	
	private Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Demo getDemo() {
		return demo;
	}
	public void setDemo(Demo demo) {
		this.demo = demo;
	}
	
	public List<String> getSlist() {
		return slist;
	}
	public void setSlist(List<String> slist) {
		this.slist = slist;
	}
	
	public int getDid() {
		return did;
	}
	
	public void setDid(int did) {
		this.did = did;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UsersVo() {
		
	}
	
	public UsersVo(Integer id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
}
