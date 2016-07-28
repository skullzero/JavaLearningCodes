package onion.open.spring.ioc;

public class ClientManager 
{
	private Client client;
	private Client client2;
	
	//构造函数注入
	public ClientManager(Client client)
	{
		this.client = client;
	}
	//属性注入
	public void setClient2(Client client2)
	{
		this.client2 = client2;
	}
	
	public void addNewClient()
	{
		client.createClient();
	}
	public void addNewClient2()
	{
		client2.createClient();
	}	
}
