package skullzero.java.basic.collection;

import java.util.*;
import org.junit.*;

public class TestList 
{
	private ArrayList<String> arrayList; 
	
	
	@Test
	public void startTesting()
	{
		testArrayList();
	}
	
	private void testArrayList()
	{
		//ArrayList不是线程安全的，Vector是
		//适合有排序需求的情况
		arrayList = new ArrayList<String>();
		
		//1.add and get
		for(int i = 100; i > 0; i--)
		{
			arrayList.add("" + i);
		}
		
		System.out.println(arrayList.get(99));
	
		//2.test wrong type, can't complete compile.
		//int temp = 999;
		//arrayList.add(temp);
		
		//3. 字符串排序
		 Collections.sort(arrayList);
		 System.out.println(arrayList.toString());

	}
}
