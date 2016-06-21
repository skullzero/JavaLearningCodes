package onion.basic.oop;

import org.junit.*;

public class Testinheritance1
{
	@Test
	public void testingStart()
	
	{
		//Scenario 1
		Base b = new Base();
		System.out.println(b.count);
		b.display();
		
		//Scenario 2
		Derived d = new Derived();
		System.out.println(d.count);
		d.display();
		
		//Scenario 3
		Base bd = new Derived();
		System.out.println(bd.count);
		bd.display();
		
		//Scenario 4
		Base d2b = d;
		System.out.println(d2b.count);
		d2b.display();
	}
}

class Base
{
    int  count  =   2 ;  
    public void display()  
    {   
    	System.out.println("Base------" + this.count);  
    }  	
}

class Derived extends Base
{
    int  count  =   20 ;  
    @Override
    public void display()  
    {   
    	System.out.println("Derived------" + this.count);  
    }  	
}

