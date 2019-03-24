package cn.itcast.demo02_service;

import java.util.List;

import cn.itcast.demo06_domain.Product;

public interface ProductService {

	List<Product> findProductByCategoryName(int startIndex, int pageSize, String cname);

	int findTotalCountByCategoryName(String cname);

	Product findProductByPid(String pid);

	List<Product> searchProduct(String search);

	int findTotalCountBySearchName(String search);

	List<Product> findProductBySearchName(int startIndex, int pageSize, String search);

	boolean addProduct(Product p);

	boolean addProductImage(String imageurl);

	int findProductTotalCount();

	List<Product> findAllProduct(int startIndex, int pageSize);

	boolean delProductByPid(String pid);

	String getProductImageurl(String pid);

	boolean editProduct(Product p);

	void editimageurl1(String pid);

	boolean editimageurl2(String imageurl);

	void delProductByCname(String cname);

	List<Product> findProductByCategoryName(String cname);



}
