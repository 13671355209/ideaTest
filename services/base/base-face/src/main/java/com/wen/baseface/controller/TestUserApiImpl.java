package com.wen.baseface.controller;

import java.util.List;
import java.util.Map;

import com.wen.baseface.model.TestUser;
import com.wen.baseface.service.TestUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * TestUserApiImpl [Table Comment not set]
 * @author MR-wen
 * @version 0.0.1
 * @date 2019-06-19 16:18:23
 */
 
@RestController
@RequestMapping("/test-user")
public class TestUserApiImpl  {
	private static Logger logger = LoggerFactory.getLogger(TestUserApiImpl.class);
	@Autowired
    private TestUserService testUserService;
    
    @RequestMapping(value="/saveData", method = RequestMethod.POST)
	public TestUser saveData(@RequestBody TestUser vo) {

		try {

			TestUser retModel = testUserService.insertOrUpdate(vo);

	} catch (Exception e) {
			e.printStackTrace();

		}
		return vo;
	}

	@RequestMapping(value="/updateData", method = RequestMethod.POST )
	public TestUser updateData(@RequestBody TestUser vo) {

		try {

			TestUser retModel = testUserService.insertOrUpdate(vo);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return vo;
	}

	@RequestMapping(value="/findData", method = RequestMethod.POST)
	public List<TestUser> findData(@RequestBody Map<String, Object> map) {

		try {

			List<TestUser> retModel = testUserService.findUser(map);
			return retModel;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}


	@RequestMapping(value = "/findByPrimaryKey")
	public Integer findByPrimaryKey(@RequestParam("sid")  Integer sid) {
		try {
			Integer model = testUserService.deleteByPrimary(sid);
			return model;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}



	

}
