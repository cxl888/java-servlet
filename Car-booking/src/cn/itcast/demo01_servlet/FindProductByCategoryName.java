package cn.itcast.demo01_servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;
import cn.itcast.demo06_domain.Product;
import cn.itcast.demo07_utils.PageBean;

/**
 * Servlet implementation class FindProductByCategoryName
 */
public class FindProductByCategoryName extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curr= request.getParameter("pageNumber");
		//避免空指针异常
		if(curr==null||"".equals(curr)){
			curr="1";
		}
		int cu=Integer.parseInt(curr);
		PageBean pb=new PageBean();
		//要查询的当前页
		pb.setPageNumber(cu);
		//每页的条数
		pb.setPageSize(12);
		//获取分类的名称
		String cname= request.getParameter("cname");
		request.setAttribute("cname", cname);
		ProductService ps =new ProductServiceImpl();
		int count=ps.findTotalCountByCategoryName(cname);
		//符合条件的总条数
		pb.setTotalRecord(count);
		List<Product> list=ps.findProductByCategoryName(pb.getStartIndex(),pb.getPageSize(),cname);
		//设置符合商品的集合
		pb.setResult(list);
		//store
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/jsp/product_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
