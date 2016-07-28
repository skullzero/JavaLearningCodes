package onion.open.spring.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;

/**
 * IoC容器，最主要的就是完成对象的创建以及维护对象的依赖关系等。
 * 控制被反转之后，获得依赖对象的过程被反转了，获得依赖对象的过程由自身管理变为了由IOC容器主动注入。
 * 更合适的名字-DI Dependency Injection 依赖注入
 * http://blog.csdn.net/m13666368773/article/details/7802126 解释较清晰
 */


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
