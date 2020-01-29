package onion.basic.thread.juc.latch;

import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable
{
	private CountDownLatch latch;
	
	public Boss(CountDownLatch latch)
	{
		this.latch = latch;
	}
	
	public void run()
	{
		  System.out.println("Boss thread is working...");
          try 
          {
			this.latch.await();
          } 
          catch (InterruptedException e) 
          {
			e.printStackTrace();
          }
          System.out.println("Boss thread finished the job.");
	}
}
