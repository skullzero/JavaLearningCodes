package skullzero.java.basic.io;

import org.junit.*;
import java.io.*;
import java.util.regex.*;

public class TestFile 
{
	private File file  = new File("C:/temp/inputTxt.txt");
	private File file2 = new File("C:/temp/");
	private String regex =  "\\w+\\.txt";
	
	@Test
	public void testingStart()
	{
		System.out.println(file2.getName());
		
		if(file2.isDirectory())
		{
			System.out.println("----------list all files----------");
			for(String temp : file2.list())
			{
				System.out.println(temp);
			}
		}
		
		System.out.println("----------list files based on filter----------");
		for(String temp : file2.list(new FileFilter(regex)))
		{
			System.out.println(temp);
		}
	}
	
	class FileFilter implements FilenameFilter
	{
		private Pattern pattern;
		
		public FileFilter(String regex)
		{
			pattern = pattern.compile(regex);
		}
		
		public boolean accept(File dir, String name)
		{
			return pattern.matcher(name).matches();
		}
	}
	
}
