package cn.itcast.demo05_daoImpl;

import java.sql.*;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.demo04_dao.ProductDao;
import cn.itcast.demo06_domain.Product;
import cn.itcast.demo07_utils.JDBCUtils;

public class ProductDaoImpl implements ProductDao {

	

	public int findTotalCountByCategoryName(String cname) {
		//根据分类名称查询
		QueryRunner qr= new QueryRunner();
		if(cname==null||cname.length()<=1){
			//用户没传分类的参数
			cname="";
		}
		String sql="select count(*) from product where category like ?";
		
		Connection conn=JDBCUtils.getConnection();
		try {
			Long l=(Long)qr.query(conn, sql, new ScalarHandler(),"%"+cname);
			return l.intValue();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

	public List<Product> findProductByCategoryName(int startIndex, int pageSize, String cname) {
		//需要一个list型的结果集合
		
		QueryRunner qr=new QueryRunner();
		if(cname==null||cname.length()<=1){
			//用户没传分类的参数
			cname="";
		}
		Object[] p={"%"+cname,startIndex,pageSize};
		//ORDER BY Company DESC
		String sql="select * from product where category like ? order by shop_price desc limit ?,?";
		Connection conn=JDBCUtils.getConnection();
		try {
			List<Product> list =qr.query(conn, sql, new BeanListHandler<Product>(Product.class),p);
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public Product findProductByPid(String pid) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="select * from product where pid = ?";
		try {
			Product p=qr.query(conn, sql, new BeanHandler<Product>(Product.class), pid);
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Product> searchProduct(String search) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="select * from product where pname like ? order by shop_price desc";
		try {
			List<Product> list = qr.query(conn, sql,new BeanListHandler<Product>(Product.class),"%"+search+"%");
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public int findTotalCountBySearchName(String search) {
		
		//根据分类名称查询
		QueryRunner qr= new QueryRunner();
		/*if(search==null||search.length()<=1){
			//用户没传分类的参数
			search="";
			}*/
		String sql="select count(*) from product where pname like ?";
				
		Connection conn=JDBCUtils.getConnection();
		try {
				Long l=(Long)qr.query(conn, sql, new ScalarHandler(),"%"+search+"%");
				return l.intValue();
			 } catch (SQLException e) {
					
					e.printStackTrace();
				}
				return 0;
	}

	
	public List<Product> findProductBySearchName(int startIndex, int pageSize, String search) {
		//需要一个list型的结果集合
		
		QueryRunner qr=new QueryRunner();
		/*if(search==null||search.length()<=1){
			//用户没传分类的参数
			search="";
		}*/
				Object[] p={"%"+search+"%",startIndex,pageSize};
				//ORDER BY Company DESC
				String sql="select * from product where pname like ? order by shop_price desc limit ?,?";
				Connection conn=JDBCUtils.getConnection();
				try {
					List<Product> list =qr.query(conn, sql, new BeanListHandler<Product>(Product.class),p);
					return list;
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				return null;
	}

	public boolean addProduct(Product p) {
		String sql="insert into product values(null,?,?,?,null,?,?,?,?,?)";
		QueryRunner qr =new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		Object[] product={p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdesc(),p.getCategory(),p.getOil(),p.getRank(),p.getDisplacement()};
		try {
			qr.update(conn,sql, product);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean addProductImage(String imageurl) {
		String sql="update product set imageurl=? where imageurl is null";
		QueryRunner qr =new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		try {
			qr.update(conn,sql,imageurl);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	
	public int findProductTotalCount() {
		
		QueryRunner qr= new QueryRunner();
		String sql="select count(*) from product";
						
				Connection conn=JDBCUtils.getConnection();
				try {
						Long l=(Long)qr.query(conn, sql, new ScalarHandler());
						return l.intValue();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return 0;
	}

	public List<Product> findAllProduct(int startIndex, int pageSize) {
		//需要一个list型的结果集合
		QueryRunner qr=new QueryRunner();
		Object[] p={startIndex,pageSize};
		//ORDER BY Company DESC
		String sql="select * from product limit ?,?";
		Connection conn=JDBCUtils.getConnection();
		try {
				List<Product> list =qr.query(conn, sql, new BeanListHandler<Product>(Product.class),p);
				return list;
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
			 return null;
	}

	
	public boolean delProductByPid(String pid) {
		QueryRunner qr=new QueryRunner();
		String sql="delete from product where pid = ?";
		Connection conn=JDBCUtils.getConnection();
		try {
			qr.update(conn,sql,pid);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}

	
	public String getProductImageurl(String pid) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="select imageurl from product where pid = ?";
		try {
			
			return (String) qr.query(conn, sql, new ScalarHandler(),pid);
	        } catch (SQLException e) {
		    e.printStackTrace();
	         }
		return null;
	}

	
	public boolean editProduct(Product pro) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="update product set pname=?,rank=?,market_price=?,shop_price=?,oil=?,displacement=?,pdesc=?,category=? where pid = ?";
		Object[] p={pro.getPname(),pro.getRank(),pro.getMarket_price(),pro.getShop_price(),pro.getOil(),pro.getDisplacement(),pro.getPdesc(),pro.getCategory(),pro.getPid()};
		try {
				qr.update(conn,sql,p);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				}
		return false;
	}

	public void editimageurl1(String pid) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="update product set imageurl=? where pid = ?";
		Object[] p={"need_edit",pid};
		try {
			qr.update(conn,sql,p);
			
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return;
	}

	
	public boolean editimageurl2(String imageurl) {
		QueryRunner qr=new QueryRunner();
		Connection conn=JDBCUtils.getConnection();
		String sql="update product set imageurl=? where imageurl='need_edit'";
		try {
			qr.update(conn,sql,imageurl);
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return false;
	}

	public void delProductByCname(String cname) {
		QueryRunner qr=new QueryRunner();
		String sql="delete from product where category = ?";
		Connection conn=JDBCUtils.getConnection();
		try {
			qr.update(conn,sql,cname);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return ;
		
	}

	public List<Product> findProductByCategoryName(String cname) {
		//需要一个list型的结果集合
		QueryRunner qr=new QueryRunner();
		String sql="select * from product where category=?";
		Connection conn=JDBCUtils.getConnection();
		try {
				List<Product> list =qr.query(conn, sql, new BeanListHandler<Product>(Product.class),cname);
					return list;
			 } catch (SQLException e) {
					e.printStackTrace();
			}
			return null;
	}

}
