package cn.itcast.demo05_daoImpl;

import java.sql.*;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.demo04_dao.UserDao;

import cn.itcast.demo06_domain.User;
import cn.itcast.demo07_utils.JDBCUtils;

public class UserDaoImpl implements UserDao {
    
	public void insert(User u)  {
		//使用JDBC
		Connection conn=JDBCUtils.getConnection();
		try{
			String sql="insert into user value(null,?,?,?,?,?,?,null)";
		    PreparedStatement pst=conn.prepareStatement(sql);
		    pst.setObject(1, u.getUsername());
		    pst.setObject(2, u.getPassword());
		    pst.setObject(3, u.getRealname());
		    pst.setObject(4, u.getEmail());
		    pst.setObject(5, u.getSex());
		    pst.setObject(6, u.getBirthday());
		    pst.executeUpdate();
		    JDBCUtils.close(conn);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public User findUserByUsername(String username) {
		Connection conn=JDBCUtils.getConnection();
		User u=null;
		String sql = "select * from user where username = ?"; 
		QueryRunner runner = new QueryRunner();
		/*try{
			String sql = "select * from user where username = ?"; 
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,username );
			ResultSet rs=pst.executeQuery();
			rs.beforeFirst();
			while(rs.next()){
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setRealname(rs.getString("realname"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setBirthday(rs.getString("birthday"));
				if(rs!=null)
				{rs.close();}
				if(pst!=null)
				{pst.close();}
				JDBCUtils.close(conn);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}*/
			
	    //2、准备参数与结果集，参数为数组，结果集为int类型的结果 
		Object[] parm = {username}; 
			   
	    try { 
			   //3、获取连接对象，使用QueryRunner对象执行sql语句 
			   u=runner.query(conn, sql,new BeanHandler<User>/*范型*/(User.class), parm); //Class 反射
			 } 
	    catch (SQLException e){ 
			   e.printStackTrace(); 
			  } 
			  

		
		

		return u;
	}

	
	public void addHistoriesByUsername(String username, String history) {
		Connection conn=JDBCUtils.getConnection();
		String sql = "update user set history=? where username=?";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setObject(1, history);
			pst.setObject(2, username);
			pst.executeUpdate();
			JDBCUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int findUserTotalCount() {
		QueryRunner qr= new QueryRunner();
		String sql="select count(*) from user";
						
				Connection conn=JDBCUtils.getConnection();
				try {
						Long l=(Long)qr.query(conn, sql, new ScalarHandler());
						return l.intValue();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return 0;
	}

	@Override
	public List<User> findAllUser(int startIndex, int pageSize) {
		//需要一个list型的结果集合
				QueryRunner qr=new QueryRunner();
				Object[] p={startIndex,pageSize};
				//ORDER BY Company DESC
				String sql="select * from user limit ?,?";
				Connection conn=JDBCUtils.getConnection();
				try {
						List<User> list =qr.query(conn, sql, new BeanListHandler<User>(User.class),p);
						return list;
					 } catch (SQLException e) {
						e.printStackTrace();
					 }
					 return null;
	}

	@Override
	public boolean editUser(User u) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="update user set password=?,realname=?,email=?,birthday=?where uid = ?";
		Object[] p={u.getPassword(),u.getRealname(),u.getEmail(),u.getBirthday(),u.getUid()};
		try {
				qr.update(conn,sql,p);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				}
		return false;
	}

	@Override
	public boolean delUserByUid(String uid) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		
		String sql="delete from user where uid=?";
		
		try {
			qr.update(conn,sql,uid);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	

}
