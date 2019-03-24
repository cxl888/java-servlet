package cn.itcast.demo03_serviceImpl;

import java.util.List;

import cn.itcast.demo02_service.CategoryService;
import cn.itcast.demo04_dao.CategoryDao;
import cn.itcast.demo05_daoImpl.CategoryDaoImpl;
import cn.itcast.demo06_domain.Category;

public class CategoryServiceImpl implements CategoryService {

	
	public List<Category> findAllCategory() {
		CategoryDao cd=new CategoryDaoImpl();
		return cd.findAllCategory();
	}

	public boolean addCategory(String cname) {
		CategoryDao cd=new CategoryDaoImpl();
		return cd.addCategory(cname);
	}

	public List<String> findAllCname() {
		CategoryDao cd=new CategoryDaoImpl();
		return cd.findAllCname();
	}

	public void editProductCategory(String cname1, String cname2) {
		
		CategoryDao cd=new CategoryDaoImpl();
		cd.editProductCategory(cname1,cname2);
		return;
	}

	public boolean editCategory(Category c) {
		CategoryDao cd=new CategoryDaoImpl();
		return cd.editCategory(c);
	}

	public String findCnameByCid(String cid) {
		CategoryDao cd=new CategoryDaoImpl();
		return cd.findCnameByCid(cid);
	}

	public boolean delCategoryByCid(String cid) {
		CategoryDao cd=new CategoryDaoImpl();
		return cd.delCategoryByCid(cid);
	}

}
