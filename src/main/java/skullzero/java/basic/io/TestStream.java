package skullzero.java.basic.io;

import org.junit.*;
import java.io.*;

public class TestStream 
{
	@Test
	public void testingStart()
	{
		try
		{
			System.out.println("System encoding is " + System.getProperty("file.encoding"));			
			
			//windows下结尾处有两个不可见的特殊字符(CR和LF)
			Reader is = new FileReader("C:/temp/inputTxt.txt");
			char[] inChar = new char[200];
			is.read(inChar);
			System.out.println("----------FileReader Testing Begin----------");
			System.out.println(inChar);
			
			//BufferedReader为装饰器类，其必须包裹一个已有Reader来创建
			BufferedReader bis = new BufferedReader(new FileReader("C:/temp/inputTxt.txt"));
			BufferedReader bis2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("----------BufferedReader Testing Begin----------");
			//readLine一次读取一行
			System.out.println(bis.readLine());
			System.out.println(bis2.readLine());
			
			//StringReader将字符串作为源来读取
			StringReader sr = new StringReader("This is a testing string.");
			System.out.println("----------StringReader Testing Begin----------");
			char[] charArray = new char[30];
			sr.read(charArray);
			for(char temp : charArray)
			{
				System.out.print(temp + "/");	
			}
			
			is.close();
			bis.close();
			sr.close();
			
			
			Writer out = new FileWriter("C:/temp/inputTxt2.txt");
			out.write(inChar);
			out.flush();
		
			BufferedWriter bw = new BufferedWriter(out);
			
			out.close();
			bw.close();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		
	}
}
