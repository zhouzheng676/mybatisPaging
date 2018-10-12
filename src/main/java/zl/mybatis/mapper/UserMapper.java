package zl.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import zl.bean.TestUser;

@Mapper
public interface UserMapper
{
	public boolean addTestUser(TestUser testUser);

	public TestUser findById(Long id);

	public List<TestUser> findAll();
}
