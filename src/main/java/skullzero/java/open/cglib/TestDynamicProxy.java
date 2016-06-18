package skullzero.java.open.cglib;

import org.junit.*;

public class TestDynamicProxy 
{
	@Test
	public void testCglibProxy()
	{
		BookServiceProxy bookCglib=new BookServiceProxy();  
        BookService bookService=(BookService)bookCglib.getInstance(new BookService());  
        bookService.addBook(); 		
	}
}
