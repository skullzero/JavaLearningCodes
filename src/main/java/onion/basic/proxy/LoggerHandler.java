package onion.basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggerHandler implements InvocationHandler
{
	private Object target;
	
	public LoggerHandler(Object target)
	{
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		System.out.println("Start Logging");
		Object result = method.invoke(target, args);
		System.out.println("End Logging");
		
		return result;
	}
}
