package com.dao;

import java.util.*;
import com.entity.*;

public interface IDemoDao {

	Demo selectByPrimaryKey(Integer did);
	
	int insert(Demo d2);
	
	List<Demo> selectAll();
	
	int deleteByPrimaryKey(Integer did);
	
	int updateByPrimaryKey(Demo d2);
	
}
