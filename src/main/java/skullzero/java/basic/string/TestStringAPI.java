package skullzero.java.basic.string;

import org.junit.*;

public class TestStringAPI 
{
	@Test
	public void testingStart()
	{
		String s = "This is a test case.";
		//split
		String[] splitResult = s.split(" ");
		for(String temp : splitResult)
		{
			System.out.println(temp);	
		}
	}
}
