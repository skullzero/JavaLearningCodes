package onion.basic.thread.wait;

public class Consumer implements Runnable
{
	private Clerk clerk;
	
	public Consumer(Clerk clerk)
	{
		this.clerk = clerk;
	}
	
	public void run()
	{
		System.out.println("消费者开始消耗整数...");
		
		//消费10次整数
		for(int i = 1; i <= 10; i++)
		{
			try 
			{
				//暂停随机时间
				Thread.sleep((int)(Math.random() * 3000));
			} 
			catch (InterruptedException e) 
			{
				throw new RuntimeException(e);
			}
			
			System.out.println("消费者取走整数 " + clerk.getProduct());
		}
	}
}
