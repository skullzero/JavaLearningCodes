package onion.basic.thread.threadlocal;

import org.apache.commons.codec.binary.StringUtils;

public class NormalThreadTest
{
	public static void main(String[] args)
	{
		Customer cust = new Customer();
		
		Thread thread1 = new Thread(new Runnable() {			
			public void run()
			{
				int count = 0;
				while(count < 20)
				{
					try {
						cust.setStatus("active");
						Thread.sleep(100);
						cust.setCustomerName("abc");
						
						if(!StringUtils.equals(cust.getStatus(), "active"))
						{
							System.out.println("-----Wrong Status --- " + cust.toString());
						}
						else
						{
							System.out.println(cust.toString());
						}
					} 
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					count++;
				}
			}
		});
		
		
		Thread thread2 = new Thread(new Runnable() {		
			public void run()
			{
				int count = 0;
				while(count < 20)
				{
					try {
						cust.setStatus("inactive");
						Thread.sleep(500);
						cust.setCustomerName("abc2");
						
						if(!StringUtils.equals(cust.getStatus(), "inactive"))
						{
							System.out.println("-----Wrong Status --- "+ cust.toString());
						}
						else
						{
							System.out.println(cust.toString());
						}
					} 
					catch (Exception e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
					count++;
				}
			}
			
		});
		
		Thread thread3 = new Thread(new Runnable() {		
			public void run()
			{
				int count = 0;
				while(count < 20)
				{
					try {
						cust.setStatus("initial");
						Thread.sleep(1000);
						cust.setCustomerName("abc3");
						
						if(!StringUtils.equals(cust.getStatus(), "initial"))
						{
							System.out.println("-----Wrong Status --- "+ cust.toString());
						}
						else
						{
							System.out.println(cust.toString());
						}
					} 
					catch (Exception e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
					count++;
				}
			}
			
		});		
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
	}
}