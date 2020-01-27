package onion.basic.thread.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableTest 
{
	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{

        System.out.println("start main thread ");

        ExecutorService exec = Executors.newFixedThreadPool(5);

        for(int i=0; i < 10; i++)
        {
        		exec.execute(new RunnableResult(i));
        }

        //关闭线程池
        exec.shutdown();
    }
}

class RunnableResult implements Runnable
{
	private int id;
	
	public RunnableResult(int id)
	{
		this.id = id;
	}
	
	public void run()
	{
		System.out.println("task " + id + " 被提交到线程" + Thread.currentThread().getName() + "执行"); 
	}
}
