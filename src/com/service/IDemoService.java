package com.service;

import java.util.*;

import com.entity.*;

public interface IDemoService {

	Demo selectByPrimaryKey(Integer did);
	
	int insert(Demo d2);
	
	List<Demo> selectAll();
	
	int deleteByPrimaryKey(Integer did);
	
	int updateByPrimaryKey(Demo d2);
}
