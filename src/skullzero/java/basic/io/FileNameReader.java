package skullzero.java.basic.io;

import java.io.*;

public class FileNameReader 
{
	public static void main(String[] args)
	{
		FileNameReader reader = new FileNameReader();
		reader.readFilesName();
	}
	
	public void readFilesName()
	{
		//String filepath="C:\\JavaOpenSource\\mule-standalone-3.1.2\\lib\\mule";
        String filepath="/Users/onion/downloads";
        
		File file = new File(filepath);
		if (file.isDirectory()) 
		{
		    System.out.println("Folder");
		    String[] filelist = file.list();
		    for (int i = 0; i < filelist.length; i++) 
		    {
		        File readfile = new File(filepath + "//" + filelist[i]);
		        if (!readfile.isDirectory()) 
		        {
				System.out.println(readfile.getName());
		        } 
		    } 
		} 		
	}
}
