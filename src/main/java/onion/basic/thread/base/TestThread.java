package onion.basic.thread.base;

import java.io.*;

/*
 * 这个例子演示了多线程中的状态转换，包含
 * New 新创建
 * RUNNABLE 线程执行，线程需要的一切准备资源都已就绪
 * BLOCKED  阻塞状态，执行中遇到synchronized同步块
 * TERMINATED 执行完毕
 */
public class TestThread 
{
	//Junit不太适合测试多线程，会有问题，待查
	public static void main(String[] args)
	{
		Writer out = null;
		String testFile = "";
		String os = System.getProperty("os.name");
		
		if(os.indexOf("Windows") != -1)
		{
			testFile  = "C:/temp/ThreadTesting.txt";
		}
		else if(os.indexOf("Mac OS") != -1)
		{
			testFile = "/Users/onion/Documents/Development/temp/ThreadTesting2";
		}
		
		try
		{		
			//构造函数中的第二个参数true表示以追加形式写文件
			out = new FileWriter(testFile, true);
			
			Thread thread1 = new Thread(new OperateFile("Thread1", out));
			Thread thread2 = new Thread(new OperateFile("Thread2", out));
			Thread thread3 = new Thread(new OperateFile("Thread3", out));
			Thread thread4 = new Thread(new OperateFile("Thread4", out));
			Thread thread5 = new Thread(new OperateFile("Thread5", out));
		
			//all NEW
			System.out.println("1 status are " + thread1.getState()  + 
								" " + thread2.getState() + 
								" " + thread3.getState() + 
								" " + thread4.getState() + 
								" " + thread5.getState());	
			
			thread1.start();
			System.out.println("2 thread1's status is " + thread1.getState()); 
			thread2.start();
			System.out.println("2 thread2's status is " + thread2.getState()); 
			thread3.start();
			System.out.println("2 thread3's status is " + thread3.getState()); 
			thread4.start();
			System.out.println("2 thread4's status is " + thread4.getState()); 
			thread5.start();
			System.out.println("2 thread5's status is " + thread5.getState()); 
						
			
			while(thread1.isAlive() || thread2.isAlive() || thread3.isAlive() || thread4.isAlive() || thread5.isAlive())
			{
				System.out.println("3 status are " + thread1.getState()  + 
									" " + thread2.getState() + 
									" " + thread3.getState() + 
									" " + thread4.getState() + 
									" " + thread5.getState());	
			}
			
			out.flush();
			out.close();

			System.out.println("4 status are " + thread1.getState()  + 
								" " + thread2.getState() + 
								" " + thread3.getState() + 
								" " + thread4.getState() + 
								" " + thread5.getState());				
		}
		catch(IOException e)
		{
			System.out.println("====e1");
			e.printStackTrace();
		}
	}
}
