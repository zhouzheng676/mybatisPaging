package zl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import zl.bean.TestUser;
import zl.service.UserService;

@RestController
public class UserController
{
	@Autowired
	private UserService userService;

	@RequestMapping("/findall")
	public List<TestUser> demo1()
	{
		List<TestUser> list = userService.findAll();
		return list;
	}

	@RequestMapping("/find/{id}")
	@HystrixCommand(fallbackMethod = "getFallback")
	public TestUser demo2(@PathVariable("id") Long id)
	{
		TestUser testUser = userService.findById(id);
		if (null == testUser)
		{
			throw new RuntimeException("部门信息不存在！");
		}
		return testUser;
	}

	public TestUser getFallback(@PathVariable("id") Long id)
	{ // 此时方法的参数 与get()一致
		TestUser vo = new TestUser();
		vo.setUsername("【ERROR】Microcloud-Dept-Hystrix"); // 错误的提示
		vo.setPassword("DEPT-Provider");
		return vo;
	}

	@RequestMapping("/add")
	public String demo3(TestUser testUser)
	{
		userService.addTestUser(testUser);
		return "success";
	}
}
