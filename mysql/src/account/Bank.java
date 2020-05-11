package account;
//事物的操作，模拟银行转账

import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author hyc
 * @date 2020/5/11
 */
public class Bank {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            //获取链接
            connection = JDBCUtil.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            //定义sql
            String sql1 = "update accounts set account = account - ? where name = ?";
            String sql2 = "update accounts set account = account + ? where name = ?";
            //获得执行对象
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);

            preparedStatement1.setDouble(1,500);
            preparedStatement2.setDouble(1,500);

            preparedStatement1.setString(2,"Tom");
            preparedStatement2.setString(2,"Jerry");

            //先执行一条
            preparedStatement1.executeUpdate();
            //引发异常
//            int i = 3/0;
            //执行第二条
            preparedStatement2.executeUpdate();
            //最后提交事务
            connection.commit();
        } catch (Exception e) {
            //在这里进行事物的回滚
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.close(preparedStatement1,connection);
            JDBCUtil.close(preparedStatement2,null);
        }
    }
}
