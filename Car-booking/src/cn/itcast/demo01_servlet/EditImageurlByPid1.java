package cn.itcast.demo01_servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;
import cn.itcast.demo06_domain.Product;

/**
 * EditImageurlByPid1
 */
public class EditImageurlByPid1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		ProductService ps =new ProductServiceImpl();
		//del
		String imageurl=ps.getProductImageurl(pid);
		String path=this.getServletContext().getRealPath("");
		String[] imagepath =null;
		imagepath=imageurl.split("/");
		for (int i = 0; i <imagepath.length; i++){
			path+="\\"+imagepath[i];
		}
		File file = new File(path);
        if(file.exists()){
           
        	file.delete();
        }
        Product p=ps.findProductByPid(pid);
        ps.editimageurl1(pid);
        request.setAttribute("pname",p.getPname());
        request.getRequestDispatcher("/admin/product/editimage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
