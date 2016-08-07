package onion.open.hibernate;

import org.hibernate.SessionFactory;  
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.*;

import onion.open.hibernate.entity.*;
import java.util.*;

/*
 * 1. 当遇到错误“xxxxreferences an unknown entityxxxxxx”，检查配置文件中是否已经定义了entity
 * 2. 工具生成的默认都是双向关系
 */

public class TestHibernate 
{
	public static void main(String[] args)
	{
		Configuration cfg = new Configuration().configure(); 
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		SessionFactory sf = cfg.buildSessionFactory(builder.build());
		Session session = sf.openSession();
		
		//Query query = session.createQuery("from User u where u.group.id=:group_id");
		//query.setInteger("group_id", 2);
		Query query = session.createQuery("from User u where u.id=:user_id");
		query.setInteger("user_id", 1);
		List<User> result = query.list();
		for(User user : result)
		{
			//Many-To-One(User-To-Group)
			System.out.println("======many to one======");
			System.out.println("username=" + user.getUsername());
			System.out.println("group=" + user.getGroup().getGroupName());
			
			//One-To-One(User-To-IdInfo)
			//采用ManyToOne表示一对一时，指定多的一段为Unique，这样就限制了多的一端的多重性为一
			//唯一外键关系模型
			System.out.println("======one to one， from User to IdInfo======");
			System.out.println("username=" + user.getUsername());
			System.out.println("id number=" + user.getIdInfo().getIdentityNum());
		}
		
		//One-To-One(IdInfo-To-User)
		Query query2 = session.createQuery("from IdInfo i where i.id=:idInfo_id");
		query2.setInteger("idInfo_id", 100);
		List<IdInfo> result2 = query2.list();
		for(IdInfo idInfo : result2)
		{
			System.out.println("======one to one， from IdInfo to User======");
			for(User user : idInfo.getUsers())
			{
				System.out.println("username="+user.getUsername());	
			}
		}
		
	}
}
