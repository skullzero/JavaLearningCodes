package skullzero.java.basic.thread;

public class TestThread 
{
	//Junit不太适合测试多线程，会有问题，待查
	public static void main(String[] args)
	{
		for(int i = 1; i < 5; i++)
		{
			new Thread(new OperateFile("Thread" + i)).start();
		}		
	}
	

}
