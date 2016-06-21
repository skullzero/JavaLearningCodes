package onion.basic.collection;

public class Student1 
{
	public String name;
	public String number;
	public Student1(String name, String number)
	{
		this.name = name;
		this.number = number;
	}
	
	@Override
	public String toString()
	{
		return String.format("(%s, %s)", name, number);
	}
}
