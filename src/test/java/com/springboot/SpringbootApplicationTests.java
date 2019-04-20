package com.springboot;

import com.springboot.dao.IUserDao;
import com.springboot.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {
	@Autowired
	private IUserDao userDao;

	@Test
	public void contextLoads() {
		UserModel userById = userDao.getUserById(1);
		UserModel userByName = userDao.getUserByName("1");
	}
}
