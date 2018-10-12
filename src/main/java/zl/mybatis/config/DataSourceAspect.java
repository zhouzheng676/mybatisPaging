package zl.mybatis.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect
{
	Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

	@Before("execution(* zl.mybatis.mapper.*.*(..))")
	public void setDataSourcePgKey(JoinPoint point)
	{
		MethodSignature signature = (MethodSignature) point.getSignature();
		// 获取DAO层方法
		String methodName = signature.getMethod().getName();
		if (methodName.contains("add") || methodName.contains("insert"))
		{
			logger.info("===========================使用数据源DB_opreate=======================");
			DatabaseContextHolder.setDatabaseType(DatabaseType.operateDS);
		}
		else
		{
			logger.info("===========================使用数据源DB_route=======================");
			DatabaseContextHolder.setDatabaseType(DatabaseType.routeDS);
		}
	}

}
