package com.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.entity.*;
import com.service.IDemoService;

@Service("demoService") // ������ע�� 
public class DemoService implements IDemoService{

	private IDemoDao demoDao ;

	public IDemoDao getDemoDao() {
		return demoDao;
	}

	@Autowired // �Զ�ע�� 
	public void setDemoDao(IDemoDao demoDao) {
		this.demoDao = demoDao;
	}

	public Demo selectByPrimaryKey(Integer did) {
		
		return demoDao.selectByPrimaryKey(did);
	}

	public int insert(Demo d2) {
		
		return demoDao.insert(d2);
	}

	public List<Demo> selectAll() {
		
		return demoDao.selectAll();
	}

	@Override
	public int deleteByPrimaryKey(Integer did) {
		
		return demoDao.deleteByPrimaryKey(did);
	}

	@Override
	public int updateByPrimaryKey(Demo d2) {
		
		return demoDao.updateByPrimaryKey(d2);
	}
	
}
