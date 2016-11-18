package onion.basic.thread.join;

import org.apache.tools.ant.taskdefs.Sleep;

public class ThreadB implements Runnable
{
	public void run()
	{
		System.out.println("Thread B 开始运行。。。");
		try 
		{
			for(int i = 1; i <= 5; i++)
			{
				Thread.sleep(3000);
				System.out.println("Thread B 还在运行。。。");
			}			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
}
