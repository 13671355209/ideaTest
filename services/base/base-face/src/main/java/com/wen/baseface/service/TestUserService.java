package com.wen.baseface.service;



import com.wen.baseface.model.TestUser;

import java.util.List;
import java.util.Map;


/**
 * TestUserService [Table Comment not set]
 * @author MR-wen
 * @version 0.0.1
 * @date 2019-06-19 16:18:23
 */
 
public interface TestUserService  {
	public TestUser insertOrUpdate(TestUser model);
	public Integer deleteByPrimaryKeys(List<TestUser> models);
	public List<TestUser> findUser(Map<String, Object> map);
	public Integer deleteByPrimary(Integer models);
}

