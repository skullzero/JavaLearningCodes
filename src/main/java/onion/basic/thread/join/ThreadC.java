package onion.basic.thread.join;

public class ThreadC implements Runnable
{
	private String num;
	public ThreadC(String num)
	{
		this.num = num;
	}
	
	public void run()
	{	
		try 
		{
			System.out.println("Thread C" + num + " 开始运行。。。");
			System.out.println("Thread C" + num + " 刚刚完成一些重要工作，要休息一会");
			
			//Thread C让出CPU
			Thread.yield();
			
			System.out.println("我Thread C" + num + "  又回来了!");
			System.out.println("Thread C" + num + "  结束");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}		
	}
}
