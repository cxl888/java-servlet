package cn.itcast.demo07_utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC使用的工具类的编写：
 * 		1、注册驱动
 * 		2、获取连接
 * 		3、关闭资源
 */
public class JDBCUtils {
	private static String className = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/myshop";
	private static String user = "root";
	private static String password = "root";
	
	static{
		try {
			//1、注册驱动
			Class.forName(className);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("工具类初始化失败！");
		}
	}
	//提供一个可以获取连接对象的静态方法
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("工具类获取连接失败，请检查数据库是否存在，及数据库密码是否正确！！！");
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//提供一个关闭资源的方法
	public static void close(ResultSet r,Statement st,Connection con){
		try{
			if(r!=null){
				//System.out.println("结果集已关闭");
				r.close();
			}
			if(st!=null){
				//System.out.println("sql语句的执行对象已关闭");
				st.close();
			}
			if(con!=null){
				//System.out.println("会话已关闭");
				con.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//重载的关闭资源的方法（仅关闭连接）
	public static void close(Connection con){
		try{
			if(con!=null){
				//System.out.println("会话已关闭");
				con.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
