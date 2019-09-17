package com.wen.baseface.service.impl;

import java.util.List;
import java.util.Map;

import com.wen.baseface.annotation.ReadDataSource;
import com.wen.baseface.annotation.WriteDataSource;


import com.wen.baseface.dao.TestUserMapper;
import com.wen.baseface.model.TestUser;
import com.wen.baseface.service.TestUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * TestUserServiceImpl [Table Comment not set]
 * @author MR-wen
 * @version 0.0.1
 * @date 2019-06-19 16:18:23
 */
 
@Service
@Transactional
public class TestUserServiceImpl  implements TestUserService
{
	private static final Logger logger = LoggerFactory.getLogger(TestUserServiceImpl.class);
	@Autowired
	private TestUserMapper testUserMapper;

	@Override
	@WriteDataSource
	@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false)
	public TestUser insertOrUpdate(TestUser model) {
		if (model.getSid()==null) {
			testUserMapper.insertSelective(model);
			return model;
		} else {

			testUserMapper.updateByExampleSelective(model,null);
			return model;
		}
	}
	@Override
	public Integer deleteByPrimaryKeys(List<TestUser> models) {
		int count = 0;
		if (models!=null && models.size()>0) {
			for (TestUser model:models) {
				int delCount = testUserMapper.deleteByExamples(model.getSid());
				count = count + delCount;
			}
		}
		return count;
	}

	@Override
	@ReadDataSource
	public List<TestUser> findUser(Map<String, Object> map) {

		return testUserMapper.selectByExample(null);
	}

	@Override
	@WriteDataSource
	public Integer deleteByPrimary(Integer models) {
		return null;//testUserMapper.deleteByPrimaryKey(models);
	}
}
