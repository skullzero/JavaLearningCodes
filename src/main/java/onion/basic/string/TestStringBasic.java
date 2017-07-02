package onion.basic.string;

import org.junit.Test;

public class TestStringBasic 
{
	@Test
	public void testStringObject()
	{
		/* a==b 因为他们都指向 方法区 中的一个 字符创常量，他们的引用是相同的
		 * 当相同的字符串常量被多次创建时，只会保存字符串常量的一个副本，称为“字符串驻留”。
		 * Java中，所有编译时字符串常量都是驻留的
		*/
		String a = "abc";
		String b = "abc";
		System.out.println("a==b:" + (a==b));
		System.out.println("a.equals(b):" + (a.equals(b))); 
		
		
		//c==d等于false是因为c和d指向 堆 中的不同对象。不同的对象拥有不同的内存引用。
		String c = new String("abc");
		String d = new String("abc");
		System.out.println("c==d:" + (c==d));
		System.out.println("c.equals(d):" + (c.equals(d))); 
		
	}
}
