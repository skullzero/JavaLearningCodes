package onion.open.log;

import org.junit.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


/*
 * logback-core：其它两个模块的基础模块
 * logback-classic：它是log4j的一个改良版本，同时它完整实现了slf4j API使你可以很方便地更换成其它日志系统如log4j或Java Logging
 * logback-access：访问模块与Servlet容器集成提供通过Http来访问日志的功能
 * 
 * 级别排序为： TRACE < DEBUG < INFO < WARN < ERROR
 * 
 * 配置文件logback.xml在resources文件夹下
 */

public class TestLogback 
{
	private final static Logger logger = LoggerFactory.getLogger(TestLogback.class);
	
	@Test
	public void log2Console()
	{
		logger.trace("logback 成功了");
		logger.debug("logback 成功了");		
		logger.info("logback 成功了");
		logger.warn("logback 成功了");
		logger.error("logback 成功了");
		
	}
}
