package onion.basic.thread;

import java.io.*;

public class OperateFile implements Runnable
{
	private StringReader sr;
	private char[] charArray;
	private String threadName;
	private Writer out;
	
	public OperateFile(String threadName, Writer out)
	{
		this.threadName = threadName;
		this.out = out;
	}
	
	public void writeFile()
	{
		try
		{
			System.out.println("-----" + threadName + "-----");
			sr = new StringReader("-----" + threadName + "-----");
			charArray = new char[20];
			sr.read(charArray);

			synchronized (out) 
			{
				System.out.println("----- wirte " + threadName);
				out.write(charArray);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	

	public void run()
	{
		writeFile();
	}
}
