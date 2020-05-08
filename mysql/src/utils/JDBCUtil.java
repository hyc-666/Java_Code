package utils;
//JDBC d的工具类

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author hyc
 * @date 2020/5/8
 */

public class JDBCUtil {
    //将路径写为静态成员，然后由读取文件的静态代码块来读取
    private static String url;
    private static String user;
    private static String password;
    //另外把driver也写进来
    private static String driver;
    //获取资源链接对象
    static {
        //加载lei
        try {
            Properties properties = new Properties();
            //获取src目录下的文件的方式，使用类加载器,有时候写相对路径有可能有问题，写绝对路径又不方便
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();//获取类加载器
            //这里这个路径是直接到src目录下的
            URL resource = classLoader.getResource("jdbc.properties");
            //要把url转成字符串
            assert resource != null;//断言非空
            String path = resource.getPath();
            //然后使用这个路径
//            properties.load(new FileReader("src/jdbc.properties"));
            properties.load(new FileReader(path));
            //读取文件内容，给静态成员赋值
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    //释放资源
    public static void close(Statement statement, Connection connection){
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //注意，两个关闭资源的方法不能写在一个try-catch里
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        //关闭资源的顺序也不能错
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //注意，两个关闭资源的方法不能写在一个try-catch里
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
