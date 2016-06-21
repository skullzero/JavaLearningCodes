package onion.basic.collection;

import java.util.*;

import org.junit.*;

public class TestList 
{
	private ArrayList<String> arrayList;
	private ArrayList<Student2> student2List;
	
	
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
		 
		 /*
		 * 4.测试排序, 按分数排序, Comparable方式
		 */
		 student2List = new ArrayList<Student2>();
		 Student2 student3_1 = new Student2("aaa", "00001", 70);
		 Student2 student3_2 = new Student2("bbb", "00002", 92);
		 Student2 student3_3 = new Student2("ccc", "00003", 50);
		 Student2 student3_4 = new Student2("ddd", "00004", 100);
		 Student2 student3_5 = new Student2("eee", "00005", 15);
		 student2List.add(student3_1);
		 student2List.add(student3_2);
		 student2List.add(student3_3);
		 student2List.add(student3_4);
		 student2List.add(student3_5);
		 Collections.sort(student2List);
		 System.out.println("-------------排序测试1------------");
		 System.out.println(student2List.toString());
		 
		 /*
		  * 5. 测试排序，按分数排序, Comparator方式，重载的sort()
		  */
		 Collections.sort(student2List, new StudentComparator());
		 System.out.println("-------------排序测试2------------");
		 System.out.println(student2List.toString());
		 

	}
}
