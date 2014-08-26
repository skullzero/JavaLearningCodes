package skullzero.java.basic.collection;

public class Student2 
{
	public String name;
	public String number;
	public Student2(String name, String number)
	{
		this.name = name;
		this.number = number;
	}

	@Override
	public String toString()
	{
		return String.format("(%s, %s)", name, number);
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
}
