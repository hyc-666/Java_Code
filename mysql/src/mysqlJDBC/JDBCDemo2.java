package mysqlJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hyc
 * @date 2020/5/8
 */
//修改数据
public class JDBCDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///shuihu",
                    "root","hyc999");
            String sql = "update hero set nickname = '呼保义' where id = 1";
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
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
