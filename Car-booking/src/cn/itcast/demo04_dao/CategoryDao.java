package cn.itcast.demo04_dao;

import java.util.List;

import cn.itcast.demo06_domain.Category;

public interface CategoryDao {

	List<Category> findAllCategory();

	boolean addCategory(String cname);

	List<String> findAllCname();

	void editProductCategory(String cname1, String cname2);

	boolean editCategory(Category c);

	String findCnameByCid(String cid);

	boolean delCategoryByCid(String cid);

}
