package skullzero.java.jvm;

import java.util.*;

/*测试用虚拟机参数
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * 生成的heap dump文件在工程根目录下
 * 
 */

public class HeapOutOfMemoryError 
{
	static class OOMObject{};
	public static void main(String[] args)
	{
		List<OOMObject> list = new ArrayList<OOMObject>();
		while(true)
		{
			list.add(new OOMObject());
		}
		
	}
}
