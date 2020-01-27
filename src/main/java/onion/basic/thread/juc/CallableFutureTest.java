package onion.basic.thread.juc;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 线程用于执行异步任务，单个的线程既是工作单元也是执行机制，从JDK1.5开始，为了把工作单元与执行机制分离开，
 * Executor框架诞生了，他是一个用于统一创建与运行的接口。Executor框架实现的就是线程池的功能。
 * 
 * Executor框架是一个根据一组执行策略调用，调度，执行和控制的异步任务的框架。
 * 
 * https://blog.csdn.net/tongdanping/article/details/79604637
 * https://javarevisited.blogspot.com/2016/12/difference-between-thread-and-executor.html
 * https://segmentfault.com/a/1190000013813740?utm_source=index-hottest
 * 
 * 1.In the case of a thread, it's developer's responsibility to create and start the thread, 
 * but in the case of Executor, the framework will create and start threads for you. 
 * 
 * 2.In the case of Thread, the task is executed by the Thread which accepts Runnable instance, 
 * but in the case of Execution the command (a Runnable implementation) may be executed in a new thread, 
 * a pooled thread or in the calling thread itself, depending upon the implementation of Executor interface.
 * 
 */

public class CallableFutureTest 
{
	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{

        System.out.println("start main thread ");

        ExecutorService exec = Executors.newFixedThreadPool(5);
        ArrayList<Future<String>> resultList = new ArrayList<Future<String>>();

        for(int i=0; i < 10; i++)
        {
        		/*
        		 * 新建一个Callable任务，并将其提交到一个ExecutorService. 将返回一个描述任务情况的Future.
        		 * 新建到callable对象被哪个线程执行，在什么时候执行都是有可能的
        		 * 有可能一个线程会执行多个task
        		 * 
        		 */
        		Future<String> task = exec.submit(new CallableResult(i));
        		resultList.add(task);
        }
        
        for(Future<String> task : resultList)
        {
        		if(task.isDone())
        		{
        			System.out.println(task.get());
        		}
        }

        //关闭线程池
        exec.shutdown();
    }
}

class CallableResult implements Callable<String>
{
	private int id;
	
	public CallableResult(int id)
	{
		this.id = id;
	}
	
	public String call() throws Exception
	{
		System.out.println("task " + id + " 被提交到线程" + Thread.currentThread().getName() + "执行"); 
		//System.out.println("task " + id + "被提交到线程" + Thread.currentThread().getName() + "执行" + " 2"); 
		//System.out.println("task " + id + "被提交到线程" + Thread.currentThread().getName() + "执行" + " 3"); 
		//System.out.println("task " + id + "被提交到线程" + Thread.currentThread().getName() + "执行" + " 4"); 
		
        //该返回结果将被Future的get方法得到  
        return "call()方法被自动调用，任务返回的结果是：" + id + "    " + Thread.currentThread().getName();  
	}
}
