package cn.itcast.demo05_daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.demo04_dao.OrderDao;
import cn.itcast.demo06_domain.OrderItem;
import cn.itcast.demo06_domain.Orders;
import cn.itcast.demo06_domain.Product;
import cn.itcast.demo06_domain.User;
import cn.itcast.demo07_utils.JDBCUtils;

public class OrderDaoImpl implements OrderDao {

	public void saveOrders(Orders o) {
		String sql="insert into orders values(?,?,?,?,?,?,?,?)";
		QueryRunner qr =new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		Object[] p={o.getOid(),o.getTotalmoney(),o.getOrdertime(),o.getOrderstatus(),o.getName(),o.getPhone(),o.getAddress(),o.getUser().getUid()};
		try {
			qr.update(conn,sql,p);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public void saveOrderItem(OrderItem oi) {
		String sql="insert into orderitem values(null,?,?,?,?)";
		QueryRunner qr =new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		Object[] p={oi.getPnum(),oi.getSubtotal(),oi.getProduct().getPid(),oi.getOid()};
		try {
			qr.update(conn,sql, p);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}


	}

	public void updateOrderStatus(String oid, int i) {
		String sql="update orders set orderstatus=? where oid = ?";
		Connection conn=JDBCUtils.getConnection();
		QueryRunner qr =new QueryRunner();
		try {
			qr.update(conn, sql,i,oid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public List<Orders> findAllOrdersByUserServlet(User u) {
		String sql="select * from orders where uid=?";
		Connection conn=JDBCUtils.getConnection();
		QueryRunner qr =new QueryRunner();
		ResultSetHandler rsh=new BeanListHandler(Orders.class);
		try {
			List<Orders> list=(List<Orders>)qr.query(conn, sql, rsh, u.getUid());
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delOrderAndOrderItem(String oid) {
		//需要两条sql语句
		String sql1="delete from orderitem where oid = ?";
		String sql2="delete from orders where oid = ?";
		Connection conn=JDBCUtils.getConnection();
		QueryRunner qr =new QueryRunner();
		try {
			qr.update(conn, sql1, oid);
			qr.update(conn, sql2, oid);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
	public int findTotalCountByOrders(User u) {
		//1、编写sql语句
		String sql="select count(*) from orders where uid=?";
		//2、准备执行sql语句的核心对象及参数与结果集
		Connection conn = JDBCUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		try {
			Long l=(Long)qr.query(conn,sql,new ScalarHandler(),u.getUid());
			return l.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return 0;
	}

	
	public List<Orders> findAllOrdersByUserServlet(int startIndex, int pageSize, User u) {
		//1、编写sql语句
				String sql="select * from orders where uid=? limit ?,?";
				//2、准备执行sql语句的核心对象及参数与结果集
				Object[] p={u.getUid(),startIndex,pageSize};
				Connection conn = JDBCUtils.getConnection();
				QueryRunner qr = new QueryRunner();
				ResultSetHandler rsh=new BeanListHandler(Orders.class);
				try {
					List<Orders> list=(List<Orders>) qr.query(conn,sql,rsh,p);
					return list;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}

	@Override
	public int findOrderTotalCount() {
		QueryRunner qr= new QueryRunner();
		String sql="select count(*) from orders";
						
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
	public List<Orders> findAllOrders(int startIndex, int pageSize) {
		//需要一个list型的结果集合
		QueryRunner qr=new QueryRunner();
		Object[] p={startIndex,pageSize};
		//ORDER BY Company DESC
		String sql="select * from orders order by orderstatus limit ?,?";
		Connection conn=JDBCUtils.getConnection();
		try {
				List<Orders> list =qr.query(conn, sql, new BeanListHandler<Orders>(Orders.class),p);
				return list;
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
			 return null;
	}

	@Override
	public OrderItem findOrderItemByOid(String oid) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="select * from orderitem where oid = ?";
		try {
			OrderItem oi=qr.query(conn, sql, new BeanHandler<OrderItem>(OrderItem.class), oid);
			
			return oi;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Orders> findAllOidsByUid(String uid) {
		//需要一个list型的结果集合
				QueryRunner qr=new QueryRunner();
				int Uid=Integer.parseInt(uid);
				//ORDER BY Company DESC
				String sql="select * from orders where uid = ?";
				Connection conn=JDBCUtils.getConnection();
				try {
						List<Orders> list =qr.query(conn, sql, new BeanListHandler<Orders>(Orders.class),Uid);
						return list;
					 } catch (SQLException e) {
						e.printStackTrace();
					 }
				return null;
	}

}
