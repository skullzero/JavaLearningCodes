package skullzero.java.basic.collection;

public class Student2 implements Comparable<Student2>
{
	public String name;
	public String number;
	public int score; //测试排序用
	
	public Student2(String name, String number)
	{
		this.name = name;
		this.number = number;
	}
	
	public Student2(String name, String number, int score)
	{
		this.name = name;
		this.number = number;
		this.score = score;
	}

	/*
	 * 使Stuedent2的对象可以被System.out.println()直接输出
	 * 
	 */
	@Override
	public String toString()
	{
		return String.format("(%s, %s, %s)", name, number, score);
	}	
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(this == null) return false;
		if(getClass() != obj.getClass()) return false;
		
		final Student2 student1 = (Student2)obj;
		if(!name.equals(student1.name))
		{
			return false;
		}
		if(!number.equals(student1.number))
		{
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode()
	{
		/*
		 * 覆盖hashcode()时计算时都是两个质数相乘后加上一个该类内部与相等判断相关的基本类型变量的值或者类类型的hashcode()结果，
		 * 以增加不同对象拥有不同hash code的概率。
		 */
		int hash = 37;
		hash = hash * 13 + (this.name != null ? this.name.hashCode() : 0);
		//如果number是int类型的，则直接加上即可, hash = hash * 13 + number;
		hash = hash * 13 + (this.number != null ? this.number.hashCode() : 0);
		return hash;		
	}	
	
	/*
	 * Collections的sort()方法要求被排序的对象，必须实现java.lang.Comparable接口的compareTo()方法
	 * 该方法必须返回大于 0、 等于 0 或小于 0 的数
	 */
	public int compareTo(Student2 student2)
	{
		//return this.score - student2.score;
		return student2.score - this.score;
	}
}
