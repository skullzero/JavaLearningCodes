package onion.basic.thread.juc.latch;

import java.util.concurrent.CountDownLatch;

/*
 * Java中的闭锁(门闩)是仅一次的。当闭锁打开后就会统一执行下面的动作
 * 
 * CountDownLatch允许一个或多个线程等待其他线程完成操作。
 * 当我们调用一次CountDownLatch的countDown()方法时，N就会减1，CountDownLatch的await()会阻塞当前线程，直到N变成零。
 * 由于countDown方法可以用在任何地方，所以这里说的N个点，可以是N个线程，也可以是1个线程里的N个执行步骤。
 * 用在多个线程时，你只需要把这个CountDownLatch的引用传递到线程里。
 */

public class LatchDemo 
{
	public static void main(String[] args)
	{
		CountDownLatch downLatch = new CountDownLatch(3);
		
		Thread t1 = new Thread(new Boss(downLatch));
		Thread t2 = new Thread(new Worker(downLatch));
		Thread t3 = new Thread(new Worker(downLatch));
		Thread t4 = new Thread(new Worker(downLatch));
				
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
