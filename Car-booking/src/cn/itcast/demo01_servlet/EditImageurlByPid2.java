package cn.itcast.demo01_servlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;

/**
 * EditImageurlByPid2
 */
public class EditImageurlByPid2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
        //图片上传
		String saveDirectory =this.getServletContext().getRealPath("")+"\\products\\1";
		File savedir=new File(saveDirectory);
		if(!savedir.exists()){//如果上传目录不存在则创建它
			savedir.mkdirs();
		}
		int maxPostSize = 5 * 1024 * 1024 ;  //上传大小限制：5M
		FileRenamePolicy policy =(FileRenamePolicy)new DefaultFileRenamePolicy(); 
		MultipartRequest multi;
		multi = new MultipartRequest(request, saveDirectory, maxPostSize,"UTF-8",policy);//实现上传
		//存数据库
		Enumeration<String> files = multi.getFileNames(); //获取文件域的input名字，可能有多个	
		String name=files.nextElement();
		String imageurl=null;
		String cid=request.getParameter("cid");
		File f = multi.getFile(name);
		if(f!=null)
		{
			   String fileName = f.getName();
			   imageurl="products/1/"+fileName;
			   
		}
		//System.out.println(imageurl);
		ProductService ps= new ProductServiceImpl();
		boolean b=ps.editimageurl2(imageurl);
		if(b){
			request.setAttribute("message","商品图片修改成功!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message","商品图片修改失败!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
	}

}
