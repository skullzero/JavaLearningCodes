package onion.basic.security;

import java.io.IOException;

import org.junit.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestBase64 
{
	private String src = "onion security base64 ";
	
	@Test
	public void testJDKBase64()
	{
		BASE64Encoder jdkEncoder = new BASE64Encoder();
		String encodedSrc = jdkEncoder.encode(src.getBytes());
		System.out.println(encodedSrc);
		
		BASE64Decoder jdkDecoder = new BASE64Decoder();
	    try 
	    {
			System.out.println(new String(jdkDecoder.decodeBuffer(encodedSrc)));
		} 
	    catch (IOException e) 
	    {
			e.printStackTrace();
		}
	}
}
