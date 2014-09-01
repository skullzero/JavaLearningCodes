package skullzero.java.basic.thread;

import java.io.*;

public class OperateFile implements Runnable
{
	private String testFile;
	private String os;
	private StringReader sr;
	private char[] charArray;
	private String threadName;
	
	public OperateFile(String threadName)
	{
		os = System.getProperty("os.name");
		if(os.indexOf("Windows") != -1)
		{
			testFile  = "C:/temp/ThreadTesting.txt";
		}
		else if(os.indexOf("Mac OS") != -1)
		{
			testFile = "/Users/onion/Documents/Development/temp/ThreadTesting";
		}
		
		this.threadName = threadName;
	}
	
	public void writeFile()
	{
		try
		{
			System.out.println("-----" + threadName + "-----");
			sr = new StringReader("-----" + threadName + "-----");
			charArray = new char[30];
			sr.read(charArray);
			
			Writer out = new FileWriter(testFile);
		    out.write(charArray);
			out.flush();
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void run()
	{
		writeFile();
	}
}
