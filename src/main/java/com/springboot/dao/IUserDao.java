package com.springboot.dao;

import com.springboot.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IUserDao {
	/**
	 * 根据id查询
	 *
	 * @param id
	 * @return
	 */

	UserModel getUserById(Integer id);

	/**
	 * 根据用户名查询
	 * @param name
	 * @return
	 */
	@Select("SELECT username,password FROM user WHERE username=#{name}")
	UserModel getUserByName(String name);
}
