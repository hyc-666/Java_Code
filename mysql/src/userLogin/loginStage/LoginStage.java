package userLogin.loginStage;

//设计一个用户登陆界面，通过输入的用户名和密码，连接到mysql数据库查询用户信息来验证是否登陆成功
/**
 * @author hyc
 * @date 2020/5/9
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.JDBCUtil;

import java.awt.*;
import java.sql.*;

public class LoginStage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:pink");

        HBox hBox1 = new HBox(30);
        HBox hBox2 = new HBox(45);
        HBox hBox3 = new HBox(100);
        VBox vBox = new VBox(25);

        Label username_label = new Label("用户名:");
        TextField input_username = new TextField();
        Label password_label = new Label("密码:");
        PasswordField input_password = new PasswordField();
        Button exit_button = new Button("退出");
        Button login_button = new Button("登陆");

        vBox.getChildren().addAll(hBox1,hBox2,hBox3);

        hBox1.getChildren().addAll(username_label,input_username);
        hBox2.getChildren().addAll(password_label,input_password);
        hBox3.getChildren().addAll(exit_button,login_button);

        anchorPane.getChildren().add(vBox);
//        vBox.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(vBox,80.0);
        AnchorPane.setLeftAnchor(vBox,180.0);
        hBox3.setAlignment(Pos.CENTER);

        primaryStage.setHeight(400);
        primaryStage.setWidth(700);
        primaryStage.setTitle("用户登陆");
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        //退出按钮
        exit_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.close();
                Platform.exit();
            }
        });

        //登陆按钮
        login_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //需要把下面的代码封装成方法
                String username = input_username.getText();
                String password = input_password.getText();
                loginButton(username,password);
            }
        });

        //除此之外，还要加入回车的快捷键，输入完成以后可以直接回车进行登陆

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //判断是否按下回车键
                if (event.getCode().getName() == KeyCode.ENTER.getName()){
                    //直接执行登陆键的功能，所以，需要把刚才的登陆键里的代码封装成方法
                    String username = input_username.getText();
                    String password = input_password.getText();
                    loginButton(username,password);
                }
            }
        });
    }

    //登陆验证功能
    public static boolean login(String username,String password){
        //判断是否输入值
        if (username == null || password == null) {
            return false;
        }
        //链接数据库进行查询
        //获取链接对象
        Connection connection = null;
//        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = JDBCUtil.getConnection();
            //拼接sql语句
            //这里，这样拼接sql的字符串是不行的，存在很明显的sql注入问题，存在重大安全隐患
          /*  String sql = "select username,password from user where " +
                    "username = " + "'" + username +"'" + "and password = " + "'" + password + "'";*/
//            System.out.println(sql);
            //执行sql语句
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(sql);
            //判断是否查询到结果
            String sql = "select * from user where username = ? and password = ?";
            //要使用预编译的PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            //然后参数需要传递
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            //执行的时候不需要带参数，否则执行的是父类的代码
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
        return false;
    }

    //登陆按钮的功能

    private void loginButton(String username,String password){
        boolean login_success = login(username,password);
        if (login_success){
            System.out.println("登陆成功");
        }else {
            System.out.println("用户名或密码错误");
        }
    }
}
