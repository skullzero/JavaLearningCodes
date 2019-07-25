package onion.basic.proxy;

import java.lang.reflect.Proxy;

/*
 * 动态代理-在运行时对类进行修改，扩展添加一些功能，比如
 * 1. 在某些函数调用前后加上日志记录；
 * 2. 在某些函数加上事务的支持；
 * 3. 给某些函数加上权限控制； 等等。。。
 * 
 * 动态代理并非在运行时去修改类，而是动态地生成一个新类，让这个新类作为原有类地代理去做事情。
 * 原有类和代理类(运行时动态生成)都必须实现同一接口。所以在调用方看来，都是同一接口。
 * 
 * 如何让动态生成的类知道新的操作加于何处呢？需要新写一个实现InvocationHandler接口的类。
 * 而InvocationHandler中有一个invoke方法就是用来写扩展代码的地方。
 * 这个类充当类一个中间层，动态生成的类会调用它，并把真正的要被添加功能的方法传递给它。
 */
public class DynamicProxyTest 
{
	public static void main(String[] args)
	{
		HelloWorld hw = new HelloWorldImpl();
		LoggerHandler handler = new LoggerHandler(hw);
		
		/*动态生成新类*/
		HelloWorld proxy = (HelloWorld)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), hw.getClass().getInterfaces(), handler);
		
		/*真正调用的是LoggerHandler的invoke方法*/
		proxy.sayHello();
		/*同样，真正调用的是LoggerHandler的invoke方法*/
		proxy.sayHi();
	}
}
