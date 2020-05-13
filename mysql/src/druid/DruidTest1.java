package druid;
//数据库连接池技术

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.util.function.IntPredicate;

/**
 * @author hyc
 * @date 2020/5/13
 */
public class DruidTest1 {
    public static void main(String[] args) throws Exception {
        //数据库连接池
        //1、导入jar包
        //2、定义配置文件
        //3、加载配置文件
        Properties properties = new Properties();
        InputStream inputStream = DruidTest1.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(inputStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
