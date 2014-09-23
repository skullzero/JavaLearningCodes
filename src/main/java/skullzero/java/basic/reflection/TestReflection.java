package skullzero.java.basic.reflection;

import org.junit.*;
import java.lang.reflect.*;

public class TestReflection 
{
	@Test
	public void testingStart()
	{	
		//测试反射构造函数
		Class carClass = TestReflection.class;
		Constructor[] carConstructors = carClass.getConstructors();
		for(Constructor tempCon : carConstructors);
	}
}
