package skullzero.java.basic.string;

import org.junit.*;

public class TestStringAPI 
{
	@Test
	public void testingStart()
	{
		String s = "This is a test case.";
		
		//length()
		System.out.println("----------length()----------");
		System.out.println(s.length());
		
		//split
		System.out.println("----------split----------");
		String[] splitResult = s.split(" ");
		for(String temp : splitResult)
		{
			System.out.println(temp);
		}
		
		//charAt 取字符串中的某一字符
		System.out.println("----------charAt----------");
		System.out.println(s.charAt(1));
		
		/*compareTo 当前String对象与另一个字符串比较。相等关系返回０；
		* 不相等时，但字符串长度相等时，从两个字符串第0个字符开始比较，返回第一个不相等的字符差，
		* 另一种情况，较长字符串的前面部分恰巧是较短的字符串，返回它们的长度差。
		*/
		System.out.println("----------compareTo----------");
		String s1 = new String("abcdefghijklmn");
        String s2 = new String("abcdefghij");
        String s3 = new String("abcdefghijalmn");
        System.out.println("s1.compareTo(s2): " + s1.compareTo(s2) ); //返回长度差
        System.out.println("s1.compareTo(s3): " + s1.compareTo(s3) ); //返回'k'-'a'的字符差
        System.out.println("the unicode of k is " + (int)'k' + "  the unicode of a is " +(int)'a');
        
        //concat 连接两个字符串
        System.out.println("----------concat----------");
        String c1 = "abcd";
        String c2 = "1234";
        System.out.println(c1.concat(c2));
        
        //trim移除收尾空格
        System.out.println("----------trim----------");
        String t1 = " abcd 1234 ";
        System.out.println(t1.trim());
        
        //startsWith/endsWith 该String对象是否以prefix开始
        System.out.println("----------startsWith/endsWith----------");
        String ss = new String("write once, run anywhere!");
        String ss1 = new String("write");
        String ss2 = new String("once");
        System.out.println("ss.startsWith(ss1): " + ss.startsWith(ss1) );
        //该String对象从第6位算起，是否以"once"开始。
        System.out.println("ss.startsWith(ss2,6): " + ss.startsWith(ss2,6));
        System.out.println("ss.endsWith(\"e!\"): " + ss.endsWith("e!") );
        
        /*getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
                   该方法将字符串拷贝到字符数组中。其中，srcBegin为拷贝的起始位置、
          srcEnd为拷贝的结束位置、字符串数值dst为目标字符数组、dstBegin为目标字符数组的拷贝起始位置。
        */
        System.out.println("----------getChars----------");
        char[] sss1 = {'I',' ','l','o','v','e',' ','h','e','r','!'};//sss1=I love her!
        String sss2 = new String("you!"); 
        sss2.getChars(0,3,sss1,7); //sss1=I love you!
        System.out.println( sss1 );
        
        //substring
        System.out.println("----------substring----------");
        //第一参数是等于，第二个参数是小于
        System.out.println(s.substring(1,3));
        
        //contentEquals 将该String对象与StringBuffer对象sb进行比较。
        System.out.println("----------contentEquals----------");
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("This is a test");
        sbuffer.append(" case.");
        System.out.println(s.contentEquals(sbuffer));
        System.out.println(s.equals(sbuffer));	//equals比较的对象必须是String类型
        
        
	}
}
