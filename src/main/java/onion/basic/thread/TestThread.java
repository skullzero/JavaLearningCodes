package onion.basic.thread;

import java.io.*;

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
			
			thread1.start();
			thread2.start();
			thread3.start();
			thread4.start();
			thread5.start();
			
			while(thread1.isAlive() || thread1.isAlive() || thread1.isAlive() || thread1.isAlive() || thread1.isAlive())
			{
				System.out.println("There are still threads alive");
			}
			
			out.flush();
			out.close();
		}
		catch(IOException e)
		{
			System.out.println("====e1");
			e.printStackTrace();
		}
	}
}
