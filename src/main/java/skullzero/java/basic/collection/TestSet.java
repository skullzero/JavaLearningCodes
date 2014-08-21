package skullzero.java.basic.collection;

import java.util.*;
import org.junit.*;

public class TestSet 
{
	private HashSet<String> hs;
	
	@Test
	public void startTesting()
	{
		testHashSet();
	}
	
	private void testHashSet()
	{
		//test depulicate items
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] tokens = line.split(" ");
		Set words = new HashSet();
		for(String token : tokens)
		{
			words.add(token);
		}
		System.out.println(words);
	}
}
