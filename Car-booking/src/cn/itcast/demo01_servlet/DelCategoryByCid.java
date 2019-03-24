package cn.itcast.demo01_servlet;

import java.io.File;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.CategoryService;
import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.CategoryServiceImpl;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;
import cn.itcast.demo06_domain.Product;

/**
 * DelCategoryByCid
 */
public class DelCategoryByCid extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid=request.getParameter("cid");
		CategoryService cs=new CategoryServiceImpl();
		String cname=cs.findCnameByCid(cid);
		ProductService ps =new ProductServiceImpl();
		//删文件
		List<Product> list=ps.findProductByCategoryName(cname);
		for(int i=0;i<list.size();i++)
		{
			String path=this.getServletContext().getRealPath("");
			String[] imagepath =null;
			imagepath=list.get(i).getImageurl().split("/");
			for (int j = 0; j <imagepath.length; j++){
				path+="\\"+imagepath[j];
			}
			File file = new File(path);
	        if(file.exists()){
	           
	        	file.delete();
	        }
		}
		//再删product
		ps.delProductByCname(cname);
		//最后删分类
		boolean b=cs.delCategoryByCid(cid);
		if(b){
			request.setAttribute("message","分类删除成功!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message","分类删除失败!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
