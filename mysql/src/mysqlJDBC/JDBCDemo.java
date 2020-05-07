package mysqlJDBC;
//JDBC的规范写法

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hyc
 * @date 2020/5/7
 */
public class JDBCDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取链接对象
            connection = DriverManager.getConnection("jdbc:mysql:///shuihu",
                    "root", "hyc999");
            //创建sql
            String sql = "insert into hero values(7,'秦明','霹雳火','天猛星')";
            //获取执行对象
            statement = connection.createStatement();
            //执行sql
            int i = statement.executeUpdate(sql);
            //处理结果
            System.out.println(i);
            //释放资源放到finally语句里
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //如果出现异常，那么两个资源有可能是null的，就还可能引发空指针异常，
            //可以做一个判断，也可以再次处理
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }

            try {
                connection.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
