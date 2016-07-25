package onion.open.spring.ioc;

public class ClientManager 
{
	private Client client;
	
	public ClientManager(Client client)
	{
		this.client = client;
	}
	
	public void addNewClient()
	{
		client.createClient();
	}
}
