package com.ssm.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.crm.mapper.BaseDictMapper;
import com.ssm.crm.pojo.BaseDict;
import com.ssm.crm.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictMapper baseDictMapper ;
	
	@Override
	public List<BaseDict> getBaseDictByCode(String code) {
		return 	baseDictMapper.getBaseDictByCode(code);
	}

}
