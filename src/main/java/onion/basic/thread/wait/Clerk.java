package onion.basic.thread.wait;

public class Clerk 
{
	//只持有一个产品，-1代表没有产品了
	private int product = -1;
	
	public synchronized void setProduct(int product)
	{
		while(this.product != -1)
		{
			try 
			{
				//目前店员没有空间收产品，请稍等
				wait();
			} 
			catch (InterruptedException e) 
			{
				throw new RuntimeException(e);
			}
		}
		
		this.product = product;
		//%d十进制整数，%n换行回车
		System.out.printf("店员收货(%d)%n", this.product);
		//通知等待集合中的线程(如消费者)
		notify();
	}
	
	
	public synchronized int getProduct()
	{
		while(this.product == -1)
		{
			try 
			{
				//目前店员没货，请稍等
				wait();
			} 
			catch (InterruptedException e) 
			{
				throw new RuntimeException(e);
			}
		}
		
		//准备交货
		int p = product;
		System.out.printf("消费者取走(%d)%n", this.product);
		//货品被取走
		this.product = -1;
		//通知等待集合中的线程(如生产者)
		notify();
		//交货
		return p;		
	}
}
