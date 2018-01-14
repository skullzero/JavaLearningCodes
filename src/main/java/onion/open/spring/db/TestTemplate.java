package onion.open.spring.db;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTemplate 
{
	public static void main(String[] args)
	{
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserJdbcDAO userJdbcDAO = (UserJdbcDAO)factory.getBean("userJdbcDAO");
		
		userJdbcDAO.query("2");
	}
}
