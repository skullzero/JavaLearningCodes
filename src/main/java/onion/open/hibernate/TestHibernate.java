package onion.open.hibernate;

import org.hibernate.SessionFactory;  
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.*;

import onion.open.hibernate.entity.*;
import java.util.*;


public class TestHibernate 
{
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration().configure(); 
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		SessionFactory sf = cfg.buildSessionFactory(builder.build());
		Session session = sf.openSession();
		Query query = session.createQuery("from Group");
		//query.setInteger("group_id", 2);
		List<Group> result = query.list();
		for(Group group : result)
		{
			System.out.println("----------" + group.getGroupName());
		}
		
	}
}
