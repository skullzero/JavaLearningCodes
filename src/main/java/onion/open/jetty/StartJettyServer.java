package onion.open.jetty;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartJettyServer {

	public static void main(String[] args) 
	{
		try
		{
			Server server = new Server(38080);

			WebAppContext webapp = new WebAppContext();
			webapp.setDefaultsDescriptor("");
			webapp.setResourceBase("./web");
			webapp.setContextPath("");
			
			
			server.setHandler(webapp);
			server.start();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
