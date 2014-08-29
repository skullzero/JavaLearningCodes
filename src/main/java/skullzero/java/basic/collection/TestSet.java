package skullzero.java.basic.collection;

import java.util.*;
import org.junit.*;

public class TestSet
{
	@Test
	public void startTesting()
	{
		testOperations();
		testHashCode();
	}
	
	private void testOperations()
	{
		//test depulicate items
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] tokens = line.split(" ");
		Set<String> words = new HashSet<String>();
		for(String token : tokens)
		{
			words.add(token);
		}
		//no dupilcated items
		System.out.println(words);
		
		scanner.close();
	}
	
	private void testHashCode()
	{
		/*
		 * 1.测试没有覆写 equals()和hashCode()的情况
		 * 虽然student1_1和student1_4是同一个人，但由于没有覆写equals()和hashCode()，
		 * Java无法判断他们逻辑上是相等的, 最终相同的人别插入同一个HashSet中。
		 */
		HashSet<Student1> stuSet1 = new HashSet<Student1>();
		Student1 student1_1 = new Student1("aaa", "00001");
		Student1 student1_2 = new Student1("bbb", "00002");
		Student1 student1_3 = new Student1("ccc", "00003");
		Student1 student1_4 = new Student1("aaa", "00001");
		
		stuSet1.add(student1_1);
		stuSet1.add(student1_2);
		stuSet1.add(student1_3);
		stuSet1.add(student1_4);
		System.out.println("Student1 Set Size is " + stuSet1.size());
		System.out.println(stuSet1);
		
		/*
		 * 2.测试覆写 equals()和hashCode()的情况
		 * student2_1和student2_4只有一个被加入到HashSet中
		 */
		HashSet<Student2> stuSet2 = new HashSet<Student2>();
		Student2 student2_1 = new Student2("aaa", "00001");
		Student2 student2_2 = new Student2("bbb", "00002");
		Student2 student2_3 = new Student2("ccc", "00003");
		Student2 student2_4 = new Student2("aaa", "00001");
		stuSet2.add(student2_1);
		stuSet2.add(student2_2);
		stuSet2.add(student2_3);
		stuSet2.add(student2_4);
		System.out.println("Student2 Set Size is " + stuSet2.size());
		System.out.println(stuSet2);
		
		/*
		 * 3.测试Iterator
		 */
		Iterator<Student2> itorStud2 = stuSet2.iterator();
		Student2 tempStu2;
		while(itorStud2.hasNext())
		{
			tempStu2 = itorStud2.next();
			System.out.println(tempStu2.name + "'s number is " + tempStu2.number);
		}
		
		/*
		 * 4.测试TreeSet排序, 指定Comparator方式
		 */
		 TreeSet<Student2> stuTreeSet = new TreeSet<Student2>(new StudentComparator());
		 Student2 student3_1 = new Student2("aaa", "00001", 2);
		 Student2 student3_2 = new Student2("bbb", "00002", 92);
		 Student2 student3_3 = new Student2("ccc", "00003", 50);
		 Student2 student3_4 = new Student2("ddd", "00004", 100);
		 Student2 student3_5 = new Student2("eee", "00005", 15);
		 stuTreeSet.add(student3_1);
		 stuTreeSet.add(student3_2);
		 stuTreeSet.add(student3_3);
		 stuTreeSet.add(student3_4);
		 stuTreeSet.add(student3_5);
		 System.out.println("-------------排序测试1------------");
		 System.out.println(stuTreeSet.toString());		
		 
		 TreeSet<Student2> stuTreeSet2 = new TreeSet<Student2>();
		 stuTreeSet2.add(student3_1);
		 stuTreeSet2.add(student3_2);
		 stuTreeSet2.add(student3_3);
		 stuTreeSet2.add(student3_4);
		 stuTreeSet2.add(student3_5);
		 System.out.println("-------------排序测试2------------");
		 System.out.println(stuTreeSet2.toString());			 
		 
	}
}
