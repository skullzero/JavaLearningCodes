package skullzero.java.basic.reflection;

import org.junit.*;
import java.lang.reflect.*;

public class TestReflection 
{
	private Class carClass;
	
	@Test
	public void testingStart()
	{	
		try 
		{		
			//carClass = Car.class;
			carClass = Class.forName("skullzero.java.basic.reflection.Car");
			
			//测试反射操作构造函数
			Constructor[] carConstructors = carClass.getConstructors();
			for(Constructor tempCon : carConstructors)
			{
				System.out.println(tempCon.getName());
			}
			//测试反射操作变量
			Field tempField;
			//getDeclaredField()可以取得任一属性
			tempField = carClass.getDeclaredField("age");
			System.out.println("Car class field: " + tempField.getName() + " / type: " + tempField.getType());
			
			//getField()只能取public的属性
			//tempField = carClass.getField("name");
			tempField = carClass.getDeclaredField("name");
			System.out.println("Car class field: " + tempField.getName() + " / type: " + tempField.getType());
			
			//测试反射操作方法
			Method tempMethod;
			////getMethod()只能取public的方法
			//tempMethod = carClass.getMethod("isNew", String.class);
			tempMethod = carClass.getDeclaredMethod("isNew", String.class);
			System.out.println("Car class method: " + tempMethod.getName() + " / return type: " + tempMethod.getReturnType());
			
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
}
