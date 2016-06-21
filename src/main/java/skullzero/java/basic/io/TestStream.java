package skullzero.java.basic.io;

import org.junit.*;
import java.io.*;

/*
 * BufferedReader
 * StringReader
 * BufferedWriter
 * FileWriter
 * FileInputStream
 * BufferedInputStream
 * InputStreamReader
 * 
 * Java IO的各种流是阻塞的。这意味着，当一个线程调用read() 或 write()时，该线程被阻塞，
 * 直到有一些数据被读取，或数据完全写入。该线程在此期间不能再干任何事情了。 
 */

public class TestStream 
{
	//Readers
	private Reader reader;
	private BufferedReader br;
	private BufferedReader br2;
	private StringReader sr;
	//Writers
	private Writer out;
	private BufferedWriter bw;
	//Stream
	private FileInputStream fis;
	private FileInputStream fis2;
	private BufferedInputStream bis;
	private InputStream is;
	private FileOutputStream fos;
	
	//Others
	private char[] inChar;
	private char[] charArray;
	private String testFile;
	private String testFile2;
	private String os;
	private byte[] inByte;
	private byte[] inByte2;
	private long startTime;
	private long endTime;
	
	@Test
	public void testingStart()
	{		
		try
		{
			System.out.println("System encoding is " + System.getProperty("file.encoding"));			
			os = System.getProperty("os.name");
			if(os.indexOf("Windows") != -1)
			{
				testFile  = "C:/temp/inputTxt.txt";
				testFile2 = "C:/temp/mule-config.txt";
			}
			else if(os.indexOf("Mac OS") != -1)
			{
				testFile = "/Users/onion/Documents/Development/temp/inputTxt";
			}			
			
			testFileReader();
			testBufferedReader();
			testStringReader();
			testFileWriter();
			testFileInputStream();
			testBufferedInputStream();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		finally
		{
			try
			{
				reader.close();
				br.close();
				sr.close();
				//out.close();
				fis.close();
				bis.close();
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
		reader = new FileReader(testFile);
		inChar = new char[200];
		reader.read(inChar);
		System.out.println("----------FileReader Testing Begin----------");
		System.out.println(inChar);			
		//System.out.println(Character.SIZE);
	}	
	
	private void testBufferedReader() throws IOException
	{
		//BufferedReader(缓冲流)为装饰器类，其必须包裹一个已有Reader(节点流)来创建
		//此处System.in如果从控制台输入中文，会显示乱码。因为工程和控制台都是UTF-8编码，而
		//键盘输入的则是GBK
		br = new BufferedReader(new FileReader(testFile));
		System.out.println("----------BufferedReader Testing 1 Begin----------");
		//readLine一次读取一行
		String tempString;
		while((tempString=br.readLine()) != null)
		{
			System.out.println(tempString);	
		}
		
		//InputStreamReader是字节流 =>字符流之间的桥梁
		System.out.println("----------BufferedReader Testing 2 Begin----------");
		br2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br2.readLine());
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
		System.out.println("");
	}
	
	private void testFileWriter() throws IOException
	{
		//Writer out = new FileWriter(testFile);
		//out.write(inChar);
		//out.flush();
	}
	
	//---------------------------------------------------------------------------------------------
	
	private void testFileInputStream() throws IOException
	{
		//FileInputStream每次从文件中读入一个字节
		System.out.println("----------FileInputaStream Testing Begin----------");
		fis = new FileInputStream(testFile2);
		inByte = new byte[1024];
		startTime = System.currentTimeMillis();
		while(fis.read(inByte) != -1)
		{
			//byte类型转换为String类型
			//System.out.println(new String(inByte));
		}
		endTime = System.currentTimeMillis();
		System.out.println("Used " + (endTime - startTime) + " milliseconds");
	}
	
	private void testBufferedInputStream() throws IOException
	{
		System.out.println("----------BufferedInputaStream Testing Begin----------");
		fis2 = new FileInputStream(testFile2); 
		inByte2 = new byte[1024];
		bis = new BufferedInputStream(fis2);
		startTime = System.currentTimeMillis();
		while(bis.read(inByte2) != -1)
		{
			//System.out.println(new String(inByte));
		}		
		endTime = System.currentTimeMillis();
		System.out.println("Used " + (endTime - startTime) + " milliseconds");
	}
	
	private void testFileOputStream() throws IOException
	{
		fos = new FileOutputStream(testFile);
		
	}
	
}
