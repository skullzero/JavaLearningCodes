package skullzero.java.basic.io;

import java.io.*;
import org.junit.*;

public class TestFileOperation 
{
	@Test
	public void testingStart()
	{
		TestFileOperation fileOperate = new TestFileOperation();
		fileOperate.readFilesName();
	}
	
	public void readFilesName()
	{
		String filepath="C:/Users/hai2/Desktop/EngineJarsInMule";
        //String filepath="/Users/onion/downloads";
        
		File file = new File(filepath);
		String[] fileList = file.list();
		for(int i = 0 ;i < fileList.length; i++)
		{
			System.out.println(fileList[i]);
		}		
	}
}
