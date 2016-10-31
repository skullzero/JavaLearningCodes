package onion.open.hibernate;

import org.hibernate.SessionFactory;  
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.*;
import org.hibernate.Transaction;

import onion.open.hibernate.entity.*;
import java.util.*;

/*
 * 1. 当遇到错误“xxxxreferences an unknown entityxxxxxx”，检查配置文件中是否已经定义了entity
 * 2. 工具生成的默认都是双向关系
 *    从User到Group即多对一的关系，从Group到User即一对多的关系
 *    User和IdInfo是一对一的关系
 * 3. 单向和双向只影响数据的加载，并不影响数据的存储。
 *    不论是一对一，一对多还是多对多，单向和双向生成的数据库表是一样，单向和双向的不同是由对象模型决定的。
 *    对象模型：有方向性。它到底是单向还是双向是由对象模型决定的即配置文件决定。
 *    关系模型：没有方向性或者说是双向的。从任何一端都可以加载另一端。
 * 4. 一对一关联映射是多对一关联映射的特例，只是在“多”的一端加上唯一的限制之后，用来表示一对一的关联关系。
 * 5. 多对多关联映射是一对多关联映射的特例，它们都是使用集合来表示多的关系。
 * 6. 多对多关联不论是单向关联还是双向关联都是通过第三张表，将两个表中的主键放到第三张做一个关联。用第三张表来解决可能会造成数据冗余的问题。
 *    例如下面例子中的user_role表,在entity User和Role中都有和user_role的配置。
 * 7. 一对多关联映射和多对一关联映射的映射原理是一致的，都是在多的一端加入一个外键，指向一的一端。
 *    多对一和一对多的区别在于维护的关系不同：
 *	    多对一：多端维护一端的关系，在加载多端时，可以将一端加载上来。
 *    一对多：一端维护多端的关系，在加载一端时，可以将多端加载上来。
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
			
			//Many-To-Many
			System.out.println("======Many to Many， from User to Role======");
			for(Role role : user.getRoles())
			{
				System.out.println("role=" + role.getRoleName());
			}
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
		
		//insert data
		System.out.println("======Insert data to Table Role======");
		Role newRole = new Role();
		newRole.setRoleName("Insert_Test_1");
		Transaction tran = session.beginTransaction();
		session.save(newRole);
		tran.commit();
		
		session.close();
		
	}
}
