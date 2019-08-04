package onion.basic.thread.threadlocal;

import org.apache.commons.codec.binary.StringUtils;

/*
 * ThreadLocal不是用于解决共享变量的问题的，不是为了协调线程同步而存在，而是为了方便每个线程处理自己的状态而引入的一个机制，
 * 就像《Thinking in Java》中描述的那样："它们使得你可以将状态与线程关联起来。"
 * 
 * scenario 2 - 仍然会有多线程的问题，并没有实现数据隔离，因为每个线程保存的Customer对象的地址还都是一样的。
 * scenario 1 - 正常
 */
public class LocalThreadTest
{
	public static void main(String[] args)
	{
		Customer cust = new Customer();
		final ThreadLocal<Customer> customerLocal = new ThreadLocal<Customer>(){
            public Customer initialValue() {
            		//scenario 1	
            		return new Customer();
                
            		//scenario 2
            		//return cust;
            }
        };	
		
		Thread thread1 = new Thread(new Runnable() {			
			public void run()
			{
				int count = 0;
				while(count < 20)
				{
					try {
						//scenario 2
						//customerLocal.set(cust);
						customerLocal.get().setStatus("active");
						Thread.sleep(100);
						customerLocal.get().setCustomerName("abc");
						
						if(!StringUtils.equals(customerLocal.get().getStatus(), "active"))
						{
							System.out.println("-----Wrong Status --- " + customerLocal.get().toString());
						}
						else
						{
							System.out.println(customerLocal.get().toString());
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
						//scenario 12
						//customerLocal.set(cust);
						customerLocal.get().setStatus("inactive");
						Thread.sleep(500);
						customerLocal.get().setCustomerName("abc2");
						
						if(!StringUtils.equals(customerLocal.get().getStatus(), "inactive"))
						{
							System.out.println("-----Wrong Status --- "+ customerLocal.get().toString());
						}
						else
						{
							System.out.println(customerLocal.get().toString());
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
						//scenario 2
						//customerLocal.set(cust);
						customerLocal.get().setStatus("initial");
						Thread.sleep(1000);
						customerLocal.get().setCustomerName("abc3");
						
						if(!StringUtils.equals(customerLocal.get().getStatus(), "initial"))
						{
							System.out.println("-----Wrong Status --- "+ customerLocal.get().toString());
						}
						else
						{
							System.out.println(customerLocal.get().toString());
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