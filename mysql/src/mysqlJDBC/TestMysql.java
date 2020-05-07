package mysqlJDBC;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hyc
 * @date 2020/5/6
 */
public class TestMysql {
    //测试数据库链接
    public static void main(String[] args) throws Exception {
        //导入驱动
//        DataSource dataSource = new MysqlDataSource();
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库链接对象
        /**
         * DriverManager 驱动管理对象
         */
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shuihu",
                "root", "hyc999");
        //定义sql语句
        String sql = "insert into hero values(6,'林冲','豹子头','天雄星')";
        //获取sql执行的对象
        Statement statement = connection.createStatement();
        //执行sql
        int i = statement.executeUpdate(sql);
        //处理结果
        System.out.println(i);
        //释放资源
        statement.close();
        connection.close();

    }
}
