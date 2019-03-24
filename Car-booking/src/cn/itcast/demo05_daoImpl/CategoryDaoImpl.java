package cn.itcast.demo05_daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.demo04_dao.CategoryDao;
import cn.itcast.demo06_domain.Category;
import cn.itcast.demo07_utils.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao {

	
	public List<Category> findAllCategory() {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="select * from category";
		try {
			List<Category> list=qr.query(conn, sql,new BeanListHandler<Category>(Category.class));
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean addCategory(String cname) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="insert into category values(null,?)";
		try {
			qr.update(conn,sql,cname);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	public List<String> findAllCname() {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="select cname from category";
		try {
			List<String> list=qr.query(conn, sql,new BeanListHandler<String>(String.class));
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public void editProductCategory(String cname1, String cname2) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="update product set category=? where category=?";
		Object[] p={cname2,cname1};
		try {
			qr.update(conn,sql,p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
		
	}

	public boolean editCategory(Category c) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="update category set cname=? where cid=?";
		Object[] p={c.getCname(),c.getCid()};
		try {
			qr.update(conn,sql,p);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String findCnameByCid(String cid) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="select * from category where cid=?";
		try {
			Category c=qr.query(conn, sql,new BeanHandler<Category>(Category.class),cid);
			return c.getCname();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public boolean delCategoryByCid(String cid) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		
		String sql="delete from category where cid=?";
		
		try {
			qr.update(conn,sql,cid);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

}
