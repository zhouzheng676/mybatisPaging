package zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import zl.bean.TestUser;
import zl.mybatis.mapper.UserMapper;
import zl.service.UserService;

@Component
public class UserSreviceImpl implements UserService
{
	@Autowired
	private UserMapper userMapper;

	public boolean addTestUser(TestUser testUser)
	{
		return userMapper.addTestUser(testUser);
	}

	public TestUser findById(Long id)
	{
		return userMapper.findById(id);
	}

	public List<TestUser> findAll()
	{
		return userMapper.findAll();
	}
}
