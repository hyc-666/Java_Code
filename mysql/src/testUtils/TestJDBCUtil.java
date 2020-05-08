package testUtils;
//测试工具类

import tables.ShuihuHero;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hyc
 * @date 2020/5/8
 */
public class TestJDBCUtil {
    public static void main(String[] args) {
        List<ShuihuHero> list = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //注册驱动并获取链接
            connection = JDBCUtil.getConnection();
            //定义sql语句
            String sql = "select * from hero";
            //获取执行语句
            statement = connection.createStatement();
            //执行语句
            resultSet = statement.executeQuery(sql);
            list = TestJDBCUtil.getShuihuHeros(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,statement,connection);
        }
        Iterator<ShuihuHero> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    public static List<ShuihuHero> getShuihuHeros(ResultSet res){
        if (res == null) {
            return null;
        }
        List<ShuihuHero> list = new ArrayList<>();
        ShuihuHero hero = null;
        try {
         while (res.next()){
             int id = res.getInt("id");
             String name = res.getString("name");
             String nickname = res.getString("nickname");
             String star = res.getString(4);
             hero = new ShuihuHero();
             hero.setId(id);
             hero.setName(name);
             hero.setNickname(nickname);
             hero.setConstellation(star);
             list.add(hero);
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
