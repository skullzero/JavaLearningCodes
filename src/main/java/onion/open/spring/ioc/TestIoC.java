package onion.open.spring.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;

public class TestIoC 
{
	@Test
	public void testCreateClient()
	{
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClientManager clientM = (ClientManager)factory.getBean("clientManager");
		clientM.addNewClient();
		clientM.addNewClient2();
	}
}
