package onion.basic.thread.join;

public class ThreadA implements Runnable
{
	public void run()
	{
		System.out.println("Thread A 开始运行。。。");
		Thread threadb = new Thread(new ThreadB());
		threadb.start();
		try 
		{
			//使ThreadB加入到ThreadA中，并优先执行
			threadb.join();			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Thread A结束运行");
	}
}
