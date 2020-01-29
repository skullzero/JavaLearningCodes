package onion.basic.thread.juc.latch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable
{
	private CountDownLatch latch;
	
	public Worker(CountDownLatch latch)
	{
		this.latch = latch;
	}
	
	public void run()
	{
		  System.out.println(Thread.currentThread().getId() + " is working...");
          try 
          {
			Thread.sleep(3000);
	        System.out.println(Thread.currentThread().getId() + " finish the job.");
          } 
          catch (InterruptedException e) 
          {
			e.printStackTrace();
          }
          finally
          {
        	  	this.latch.countDown();
          }

	}
}
