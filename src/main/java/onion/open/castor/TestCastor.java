package onion.open.castor;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.Marshaller;
import java.io.OutputStreamWriter;
import org.junit.*;
import java.io.FileReader;
import org.xml.sax.InputSource;

/*
 * Castor 提供Java对象和XML自动绑定功能。
 */

public class TestCastor 
{
	private Mapping marshallMapping = new Mapping();
	private Mapping unmarshallMapping = new Mapping();
	private CustomerVO customerVO = new CustomerVO();
	
	@Test
	public void testMarshalXML()
	{
		try
		{
			//1.从mapping XML文件中加载映射信息
			//maven将main/resources下的文件编译到classes根目录下
			unmarshallMapping.loadMapping(TestCastor.class.getClassLoader()
										  .getResource("castor/CustomerVO-Unmarshall-mapping.xml")
										  .getFile());
			
			//2.解编CustomerData.xml，构造Java对象
			Unmarshaller unmar = new Unmarshaller(unmarshallMapping);
			customerVO = (CustomerVO)unmar.unmarshal(new InputSource(new FileReader("/Users/onion/git/JavaLearningCodes/target/classes/castor/CustomerData.xml")));
			System.out.println(customerVO.getCustomerID() + " - " + 
								customerVO.getCustomerName() + " - " +
								customerVO.getBirthDate() + "-" +
								customerVO.getAddressList().get(0).getType());
			
			//3.改造对象数据
			customerVO.setCustomerID("112233");
			customerVO.setCustomerName("HAHAHA");
			customerVO.setBirthDate("1980-01-01");			
			
			//4.将Java Object编组为XML并输出到控制台
			marshallMapping.loadMapping(TestCastor.class.getClassLoader()
					  .getResource("castor/CustomerVO-Marshall-mapping.xml")
					  .getFile());			
			Marshaller marshaller = new Marshaller(new OutputStreamWriter(System.out));
			marshaller.setMapping(marshallMapping);
			marshaller.marshal(customerVO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
