package skullzero.java.basic.string;

import org.junit.*;

public class TestStringCompare 
{
	@Test
	public void testingStart()
	{
		testStringEqual();
	}
	
	public void testStringEqual()
	{
		//不放在字符串池中
		String stringA = new String("aaa");
		String stringB = new String("aaa");
		System.out.println("if stringA == stringB? " + (stringA == stringB));
		
		//只有"包围的字符串会放到字符串池中
		String stringC = "bbb";
		String stringD = "bbb";
		System.out.println("if stringC == stringD? " + (stringC == stringD));
		
		String stringE = "ccc";
		String stringF = new String("ccc");
		System.out.println("if stringE == stringF? " + (stringE == stringF));		
		
		String stringG = "ddd";
		String stringH = stringG + stringC;
		String stringI = "dddbbb";
		System.out.println("if stringH == stringI? " + (stringH == stringI));
		//equals比较对象实质内容是否相同
		System.out.println("if stringH equals stringI? " + (stringH.equals(stringI)));
		
		StringBuilder stringJ = new StringBuilder("ddd");
		stringJ.append("bbb");
		System.out.println("if stringI == stringJ? " + (stringI == stringJ.toString()));
		System.out.println("if stringI == stringJ? " + (stringI.equals(stringJ.toString())));
		//System.out.println(stringA.hashCode());
		//System.out.println(stringB.hashCode());
	}
}
