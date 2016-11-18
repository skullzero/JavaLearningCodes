package onion.basic.thread.join;

/* 如果线程A正在运行，流程中允许线程B加入，等到线程B执行完毕后再继续线程A的流程，join可以达成这个需求
 * 就好比手上已经有份工作正在进行，老板安排了另一个工作并要求优先做完，然后再继续原本正在进行的工作
 * 
 * yield是Thread的一个静态方法，使当前线程让出CPU。当不意味着整个线程就不执行了，而是会继续参加CPU资源的
 * 争夺
 */

public class MainThread 
{
	public static void main(String[] args)
	{
		Thread threada = new Thread(new ThreadA());
		Thread threadc1 = new Thread(new ThreadC("1"));
		Thread threadc2 = new Thread(new ThreadC("2"));
		Thread threadc3 = new Thread(new ThreadC("3"));
		Thread threadc4 = new Thread(new ThreadC("4"));
		Thread threadc5 = new Thread(new ThreadC("5"));
		
		threadc1.start();
		threadc2.start();
		threadc3.start();
		threadc4.start();
		threadc5.start();
		threada.start();
		
		System.out.println("主线程结束");
	}
}
