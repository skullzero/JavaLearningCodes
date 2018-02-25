public class HelloWorld 
{	
		static main(def args) 
		{
			def closure = { param -> println "hello ${param}" }
			closure("world")
		}
}
