package skullzero.java.basic.collection;

import java.util.*;

import org.junit.*;

public class TestMap 
{
	private Student2 student3_1 = new Student2("aaa", "00001", 2);
	private Student2 student3_2 = new Student2("bbb", "00002", 91);
	private Student2 student3_3 = new Student2("ccc", "00003", 50);
	private Student2 student3_4 = new Student2("ddd", "00004", 99);
	private Student2 student3_5 = new Student2("eee", "00005", 15);
	
	private Map<String, Student2> stuMap = new HashMap<String, Student2>();
	
	@Test
	public void startTesting()
	{
		testOperations();
	}
	
	private void testOperations()
	{
		/*
		 * 1. 测试put
		 */
		stuMap.put("s1", student3_1);
		stuMap.put("s2", student3_2);
		stuMap.put("s3", student3_3);
		stuMap.put("s4", student3_4);
		stuMap.put("s5", student3_5);

		/*
		 * 2. 测试get
		 */
		System.out.println(stuMap.get("s3"));
		
		/*
		 * 取得Map的键
		 * keySet()返回一个Set，而Set实现了Iterable接口
		 */
		System.out.println("-------------keySet()------------");
		Iterable<String> iterable = stuMap.keySet();
		for (String id : iterable) 
		{
			System.out.println(id);
		}
		
		/*
		 * 同时取得键和值, 用entrySet()
		 */
		System.out.println("-------------entrySet()------------");
		Iterable<Map.Entry<String, Student2>> iterable2 = stuMap.entrySet();		
		for(Map.Entry<String, Student2> entry : iterable2)
		{
			System.out.printf("(%s, %s)%n", entry.getKey(), entry.getValue()) ;
		}
		
		
	}
}
