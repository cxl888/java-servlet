package cn.itcast.demo01_servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;

/**
 *   DelProductByPid
 */
public class DelProductByPid extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid=request.getParameter("pid");
		ProductService ps =new ProductServiceImpl();
		String imageurl=ps.getProductImageurl(pid);
		//System.out.println(imageurl);
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
		  
	    boolean b=ps.delProductByPid(pid);
		if(b){
			request.setAttribute("message","商品删除成功!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message","商品删除失败!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
