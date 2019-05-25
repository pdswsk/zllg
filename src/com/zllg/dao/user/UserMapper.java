package com.zllg.dao.user;

import java.util.List;

import com.zllg.pojo.User;





public interface UserMapper {
   //测试
	public int count();
	
//	增加一个用户信息
	public int add(User user);
//	根据ID来查询一个用户
	public User selectById(Integer id);
//	修改一个用户信息
	public int modify(User user);
//	根据条件查询用户
	public List<User> select();
//	根据Id删除一个用户
	public int delect(Integer id);
	
	
}
