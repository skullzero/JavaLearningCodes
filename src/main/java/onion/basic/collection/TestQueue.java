package onion.basic.collection;

import java.util.*;

import org.junit.Test;

public class TestQueue 
{
	private Queue<Student2> stuQueue = new LinkedList<Student2>();
	private Student2 student3_1 = new Student2("aaa", "00001", 2);
	private Student2 student3_2 = new Student2("bbb", "00002", 91);
	private Student2 student3_3 = new Student2("ccc", "00003", 50);
	private Student2 student3_4 = new Student2("ddd", "00004", 99);
	private Student2 student3_5 = new Student2("eee", "00005", 15);
	
	
	@Test
	public void startTesting()
	{
		stuQueue.add(student3_1);
		stuQueue.add(student3_2);
		stuQueue.add(student3_3);
		stuQueue.add(student3_4);
		stuQueue.add(student3_5);
		
		testOperations();
	}
	
	private void testOperations()
	{
		//LinkdedList实现了Queue接口 	
		System.out.println(stuQueue);
		
		/*
		 * 1. 从队列后端加入新元素 offer()
		 */
		boolean offerResult = stuQueue.offer(new Student2("fff", "00006", 20));
		if(offerResult) System.out.println("offer done");
		else System.out.println("offer failed");
		System.out.println("-------------Queue offer()------------");
		System.out.println(stuQueue);
		
		/*
		 * 2. peek()从队列前端取得，但不取出
		 */
		Student2 tempStu2 = stuQueue.peek();
		if(tempStu2 != null) System.out.println("peek done " + tempStu2.name);
		else System.out.println("peek failed");		
		System.out.println("-------------Queue peek()------------");
		System.out.println(stuQueue);
		
		/*
		 * 3. poll从队列前段 取出 对象
		 */
		Student2 tempStu3 = stuQueue.poll();
		if(tempStu3 != null) System.out.println("poll done " + tempStu3.name);
		else System.out.println("poll failed");		
		System.out.println("-------------Queue poll()------------");
		System.out.println(stuQueue);	
		
		/*
		 * 4. PriorityQueue - 测试排序 Comparable
		 */
		PriorityQueue<Student2> pStuQueue = new PriorityQueue<Student2>(10, new StudentComparator());
		pStuQueue.add(student3_1);
		pStuQueue.add(student3_2);
		pStuQueue.add(student3_3);
		pStuQueue.add(student3_4);
		pStuQueue.add(student3_5);
		System.out.println("-------------PriorityQueue 排序 1------------");
		//PriorityQueue是内部实现是二叉树，直接用toString()输出无法得到想象中的按顺序的输出
		while(!pStuQueue.isEmpty())
		{
			System.out.println(pStuQueue.poll());
		}
		//System.out.println(pStuQueue.toString());	
	}
}
