package onion.open.cglib;

import org.junit.*;

public class TestDynamicProxy 
{
	@Test
	public void testCglibProxy()
	{
		BookServiceProxy bookCglib=new BookServiceProxy();  
		BookService bookService=(BookService)bookCglib.getInstance(new BookService());
		//jar包中的class也能代理
        //BookService123 bookService=(BookService123)bookCglib.getInstance(new BookService123());  
        bookService.addBook(); 	
	}
}
