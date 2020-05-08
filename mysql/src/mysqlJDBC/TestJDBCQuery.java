package mysqlJDBC;
//测试JDBC的查询效果，并处理结果集

import java.sql.*;

/**
 * @author hyc
 * @date 2020/5/8
 */
public class TestJDBCQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///shuihu",
                    "root", "hyc999");
            String sql = "select * from hero";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String nickname = resultSet.getString("nickname");
                String star = resultSet.getString(4);
                System.out.println("排行：" + id + "  姓名：" + name + "  称号：" + nickname + "  星宿：" + star);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
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
