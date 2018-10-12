package zl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * 项目入口，启动类
 *
 * @Date 2017年11月20日
 */
@SpringBootApplication(exclude =
{ DataSourceAutoConfiguration.class })
@EnableCircuitBreaker
public class Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class);
	}
}
