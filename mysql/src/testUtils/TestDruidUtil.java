package testUtils;
//测试数据库连接池

import utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author hyc
 * @date 2020/5/13
 */
public class TestDruidUtil {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "insert into accounts values(null,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"Bob");
            preparedStatement.setDouble(2,3000);
            int count = preparedStatement.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(preparedStatement,connection);
        }
    }
}
