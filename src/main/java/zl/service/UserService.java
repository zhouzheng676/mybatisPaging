package zl.service;

import java.util.List;

import zl.bean.TestUser;

public interface UserService
{
	public boolean addTestUser(TestUser testUser);

	public TestUser findById(Long id);

	public List<TestUser> findAll();
}
