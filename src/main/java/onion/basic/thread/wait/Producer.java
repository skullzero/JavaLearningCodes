package onion.basic.thread.wait;

public class Producer implements Runnable
{
	private Clerk clerk;
	
	public Producer(Clerk clerk)
	{
		this.clerk = clerk;
	}
	
	public void run()
	{
		System.out.println("生产者开始生产整数...");
		
		//产生1到10的整数
		for(int product = 1; product <= 10; product++)
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
			
			clerk.setProduct(product);
		}
	}
}
