package onion.basic.collection;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student2>
{
	public int compare(Student2 stu2_1, Student2 stu2_2)
	{
		return stu2_1.score - stu2_2.score;
	}
}
