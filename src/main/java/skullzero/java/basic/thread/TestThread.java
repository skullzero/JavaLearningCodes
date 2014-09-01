package skullzero.java.basic.thread;

import org.junit.*;

public class TestThread 
{
	private String threadName;
	
	@Test
	public void testingStart()
	{
		for(int i = 1; i < 5; i++)
		{
			new Thread(new OperateFile("Thread" + i)).start();
		}
	}
	

}
