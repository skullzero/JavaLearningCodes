package onion.basic.thread.join;

public class MainThread 
{
	public static void main(String[] args)
	{
		Thread threada = new Thread(new ThreadA());
		threada.start();
		
		System.out.println("主线程结束");
	}
}
