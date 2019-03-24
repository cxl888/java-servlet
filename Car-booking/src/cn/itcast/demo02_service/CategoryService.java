package cn.itcast.demo02_service;

import java.util.List;

import cn.itcast.demo06_domain.Category;

public interface CategoryService {

	List<Category> findAllCategory();

	boolean addCategory(String cname);

	List<String> findAllCname();

	void editProductCategory(String cname1, String cname2);

	boolean editCategory(Category c);

	String findCnameByCid(String cid);

	boolean delCategoryByCid(String cid);

}
