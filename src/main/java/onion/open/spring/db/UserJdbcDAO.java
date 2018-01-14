package onion.open.spring.db;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import onion.open.hibernate.entity.User;

/*
 * Spring提供了org.springframework.jdbc.core.support.JdbcDaoSupport类 ， 
 * 这个类中定义了JdbcTemplate属性，也定义了DataSource属性，当设置DataSource属性的时候，会创建jdbcTemplate的实例，
 * 所以我们自己编写的DAO 只需要继承JdbcDaoSupport类，然后注入DataSource即可。
 */
public class UserJdbcDAO extends JdbcDaoSupport
{
    public void query(String user_id) 
    {
        String sql = "SELECT * FROM USER where id=?";  
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = this.getJdbcTemplate().query(sql, rowMapper, user_id);  
        for(User user:users)
        {
        		System.out.println("username = " + user.getUsername());
        }
    }
}
