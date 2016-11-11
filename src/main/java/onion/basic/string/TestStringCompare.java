package onion.basic.string;

import javassist.compiler.ast.StringL;

import org.junit.*;

public class TestStringCompare 
{
	private String stringK = "aaa1";
	private String stringM = new String("aaa2");
	
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
		
		//只有双引号包围的字符串会放到字符串池中，编译时就被当做了常量
		String stringC = "bbb";
		String stringD = "bbb";
		System.out.println("if stringC == stringD? " + (stringC == stringD));
		
		String stringE = "ccc";
		String stringF = new String("ccc");
		System.out.println("if stringE == stringF? " + (stringE == stringF));		
		
		String stringG = "ddd";
		//运行时通过计算得到的是新创建的，所以和常量池中的不一样
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
		
		changeString(stringK);
		changeString2(stringM);
	}
	
	private void changeString(String stringL)
	{
		System.out.println("if stringK == stringL? " + (stringK == stringL));
		stringL = "abcdefghijklmn";
		//no change
		System.out.println("stringK was changed by stringL? stringK=" + stringK);
	}
	
	private void changeString2(String stringN)
	{
		System.out.println("if stringM == stringN? " + (stringM == stringN));
		stringN = new String("aaa2");
		//指向了不同的对象
		System.out.println("if stringM == stringN? " + (stringM == stringN));
		System.out.println("if stringM equals stringN? " + (stringM.equals(stringN)));
	}	
	
}
