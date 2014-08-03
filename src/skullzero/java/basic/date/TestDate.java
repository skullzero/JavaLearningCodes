package skullzero.java.basic.date;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class TestDate 
{
    public static void main(String[] args)
    {
        try
        {
            //设置时区
            TimeZone TIMEZONE = TimeZone.getTimeZone("UTC"); 
            //设置格式
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss.SSS'Z'", Locale.ENGLISH);
            dateFormat.setTimeZone(TIMEZONE);
            //获得当前时间
            Date date = new Date();
            System.out.println(date);
            System.out.println(dateFormat.format(date));
            
            //格式转换
            Date date2 = dateFormat.parse("2013-05-03T01:08:46.875Z");
            System.out.println("=================" + dateFormat.parse("2013-05-03T01:08:46.875Z"));    
            
            //日期大小比较
            //返回 0 表示时间日期相同
            //返回 1 表示日期1 > 日期2
            //返回 -1 表示日期1 < 日期2
            System.out.println(date.compareTo(date2));
        }
        catch(Exception e)
        {
            
        }
    }
}
