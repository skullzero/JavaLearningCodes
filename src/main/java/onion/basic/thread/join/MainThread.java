package onion.basic.thread.join;

/*如果线程A正在运行，流程中允许线程B加入，等到线程B执行完毕后再继续线程A的流程，join可以达成这个需求
 * 就好比手上已经有份工作正在进行，老板安排了另一个工作并要求优先做完，然后再继续原本正在进行的工作
 * 
 */

public class MainThread 
{
	public static void main(String[] args)
	{
		Thread threada = new Thread(new ThreadA());
		threada.start();
		
		System.out.println("主线程结束");
	}
}
