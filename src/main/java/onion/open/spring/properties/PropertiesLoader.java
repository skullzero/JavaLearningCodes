package onion.open.spring.properties;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.*;
import java.util.Properties;

public class PropertiesLoader 
{
	private InputStream in;
	private Properties props;
	
	public void getResource()
	{
		try
		{
			/*
			 * ResourcePatternResolver版本
			 * 该类的getResouces方法不仅支持带资源类型前缀的表达式
			 * 还支持Ant风格的资源路径表达式
			 * 注意 1. 是getResources，结尾带s的
			 *     2. classpath只在第一个目标加载路径下寻找
			 *     3. 编译并不会把非class文件(e.g. properties文件)拷贝到target文件夹相应的package中
			 *        这就是为什么下面的patternString无法加载到文件的原因。
			 */
			ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
			//String patternString = "classpath*:connect*.properties";
			String patternString = "classpath*:onion/**/connect*.properties";
			Resource[] resources = resolver.getResources(patternString);
			for(Resource resource:resources)
			{
				in = resource.getInputStream();
				props = new Properties();
				props.load(in);
				System.out.println("ResourcePatternResoulver --- " + props.getProperty("database"));
			}
							
			
			/*
			 * ResourceLoaderr版本
			 * 该类的getResouce方法仅支持带资源类型前缀的表达式
			 * Maven会将main/resources文件夹下的拷贝到target中class文件夹的顶层目录中
			 * 在这个例子中，就是和onion在同一级
			 */
			ResourceLoader loader = new DefaultResourceLoader();
			Resource resource2 = loader.getResource("classpath:connection.properties");
			InputStream in2 = resource2.getInputStream();
			Properties props2 = new Properties();
			props2.load(in2);
			System.out.println("ResourceLoader --- " + props2.getProperty("database"));	
		}
		catch(Exception ie)
		{
			System.out.println(ie);
		}
		
	}
	
	
	
}
