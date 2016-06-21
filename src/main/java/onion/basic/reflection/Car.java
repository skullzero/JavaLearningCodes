package onion.basic.reflection;

public class Car 
{
	private String name;
	public int age;
	String price;
	
	
	public Car()
	{
		System.out.println("Default Constructor");
	}
	
	private boolean isNew(String name)
	{
		System.out.println("isNew method");
		return true;
	}
	
}
