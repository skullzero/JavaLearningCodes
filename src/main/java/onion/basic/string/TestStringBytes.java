package onion.basic.string;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class TestStringBytes 
{
	private String src = "Hello 世界!";
	
	@Test
	public void testGetBytes()
	{
		try 
		{
			//查看当前系统默认字符集
			System.out.println(System.getProperty("file.encoding") + " : " + src.getBytes().length);		
			
			//英文操作系统一般为ISO-8859-1，每个字符占一个字节,不论是否非拉丁字符
			System.out.println("ISO-8859-1" + " : " + src.getBytes("ISO-8859-1").length);
			//下面的输出中所有的中文字符都变成了63，63即？
			//ISO-8859-1中没有中文字符的定义
			System.out.println("bytes of ISO-8859-1 is " + arrayToString(src.getBytes("ISO-8859-1")));
			//由于上面的原因，想要从被ISO-8859-1编码后的字节数组中恢复中文将失败
			//因此,通过String.getBytes(String charset)方法来得到byte[]时,一定要确定该charset的编码表中确实存在String表示的码值,这样得到的byte[]数组才能正确被还原。
			System.out.println("ISO-8859-1 bytes to String" + " : " + new String(src.getBytes("ISO-8859-1")));
			
			//中文操作系统中一般为GBK和GB2312, 中文占2个字节
			System.out.println("GBK" + " : " + src.getBytes("GBK").length);
			System.out.println("GB2312" + " : " + src.getBytes("GB2312").length);
			System.out.println("bytes of GBK is " + arrayToString(src.getBytes("GBK")));
			
			//如果不写明charset，则java会采用系统默认的charset，则有可能在转换回String时无法得到正确的结果
			System.out.println("GBK bytes to String with System charset" + " : " + new String(src.getBytes("GBK")));
			System.out.println("GBK bytes to String" + " : " + new String(src.getBytes("GBK"), "GBK"));
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
	}
	
    public static final String arrayToString(byte[] bytes) 
    {  
        StringBuffer buff = new StringBuffer();  
        for (int i = 0; i < bytes.length; i++) 
        {  
            buff.append(bytes[i] + " ");  
        }  
        return buff.toString();  
    } 	
}
