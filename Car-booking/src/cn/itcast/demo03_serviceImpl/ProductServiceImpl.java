package cn.itcast.demo03_serviceImpl;

import java.util.List;

import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo04_dao.ProductDao;
import cn.itcast.demo05_daoImpl.ProductDaoImpl;
import cn.itcast.demo06_domain.Product;

public class ProductServiceImpl implements ProductService {

	public List<Product> findProductByCategoryName(int startIndex, int pageSize, String cname) {
		
		ProductDao pd  =new ProductDaoImpl();
		return pd.findProductByCategoryName(startIndex,pageSize,cname);
	}

	public int findTotalCountByCategoryName(String cname) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.findTotalCountByCategoryName(cname);
		
	}

	public Product findProductByPid(String pid) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.findProductByPid(pid);
	}

	
	public List<Product> searchProduct(String search) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.searchProduct(search);
	}

	
	public int findTotalCountBySearchName(String search) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.findTotalCountBySearchName(search);
	}

	
	public List<Product> findProductBySearchName(int startIndex, int pageSize, String search) {
		ProductDao pd  =new ProductDaoImpl();
		
		return pd.findProductBySearchName(startIndex,pageSize,search);
	}

	public boolean addProduct(Product p) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.addProduct(p);
	}

	public boolean addProductImage(String imageurl) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.addProductImage(imageurl);
	}
	
	public int findProductTotalCount() {
		ProductDao pd  =new ProductDaoImpl();
		return pd.findProductTotalCount();
	}

	
	public List<Product> findAllProduct(int startIndex, int pageSize) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.findAllProduct(startIndex,pageSize);
	}

	
	public boolean delProductByPid(String pid) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.delProductByPid(pid);
	}

	
	public String getProductImageurl(String pid) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.getProductImageurl(pid);
	}

	
	public boolean editProduct(Product p) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.editProduct(p);
	}

	
	public void editimageurl1(String pid) {
		ProductDao pd  =new ProductDaoImpl();
		pd.editimageurl1(pid);
		return;
	}

	public boolean editimageurl2(String imageurl) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.editimageurl2(imageurl);
	}

	public void delProductByCname(String cname) {
		ProductDao pd  =new ProductDaoImpl();
		pd.delProductByCname(cname);
		return;
		
	}

	public List<Product> findProductByCategoryName(String cname) {
		ProductDao pd  =new ProductDaoImpl();
		return pd.findProductByCategoryName(cname);
	}

}
