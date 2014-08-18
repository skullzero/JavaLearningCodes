package skullzero.java.basic.io;

import org.junit.*;
import java.io.*;

public class TestStream 
{
	//Readers
	private Reader is;
	private BufferedReader bis;
	private BufferedReader bis2;
	private StringReader sr;
	//Writers
	private Writer out;
	private BufferedWriter bw;
	//Others
	private char[] inChar;
	private char[] charArray;
	private String testFile;
	private String os;
	
	@Test
	public void testingStart()
	{		
		try
		{
			System.out.println("System encoding is " + System.getProperty("file.encoding"));			
			os = System.getProperty("os.name");
			if(os.indexOf("Windows") != -1)
			{
				testFile = "C:/temp/inputTxt.txt";
			}
			else if(os.indexOf("Mac OS") != -1)
			{
				testFile = "/Users/onion/Documents/Development/temp/inputTxt";
			}			
			
			testFileReader();
			testBufferedReader();
			testStringReader();
			testFileWriter();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
				bis.close();
				sr.close();
				out.close();
				//bw.close();			
			}
			catch(IOException io)
			{
				io.printStackTrace();
			}
		}
		
	}
	
	private void testFileReader() throws IOException
	{
		//windows下结尾处有两个不可见的特殊字符(CR和LF)
		is = new FileReader(testFile);
		inChar = new char[200];
		is.read(inChar);
		System.out.println("----------FileReader Testing Begin----------");
		System.out.println(inChar);			
	}	
	
	private void testBufferedReader() throws IOException
	{
		//BufferedReader(缓冲流)为装饰器类，其必须包裹一个已有Reader(节点流)来创建
		//此处System.in如果从控制台输入中文，会显示乱码。因为工程和控制台都是UTF-8编码，而
		//键盘输入的则是GBK
		bis = new BufferedReader(new FileReader(testFile));
		System.out.println("----------BufferedReader Testing 1 Begin----------");
		//readLine一次读取一行
		String tempString;
		while((tempString=bis.readLine()) != null)
		{
			System.out.println(tempString);	
		}
		
		//InputStreamReader是字节流和字符流之间的桥梁
		System.out.println("----------BufferedReader Testing 2 Begin----------");
		bis2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(bis2.readLine());
	}
	
	private void testStringReader() throws IOException
	{
		//StringReader将字符串作为源来读取
		sr = new StringReader("This is a testing string.");
		System.out.println("----------StringReader Testing Begin----------");
		charArray = new char[30];
		sr.read(charArray);
		for(char temp : charArray)
		{
			System.out.print(temp + "/");	
		}
	}
	
	private void testFileWriter() throws IOException
	{
		Writer out = new FileWriter(testFile);
		out.write(inChar);
		out.flush();
	}
}
