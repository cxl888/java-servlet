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

import cn.itcast.demo02_service.CategoryService;
import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.CategoryServiceImpl;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;
import cn.itcast.demo06_domain.Product;

/**
 * AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//图片上传
		/*String saveDirectory =this.getServletContext().getRealPath("")+"\\products\\1";
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
			   
		}*/
		Product p= new Product();
		p.setPname(request.getParameter("pname"));
		p.setPdesc(request.getParameter("pdesc"));
		//p.setImageurl(imageurl);
		p.setMarket_price(Double.parseDouble(request.getParameter("market_price")));
		p.setShop_price(Double.parseDouble(request.getParameter("shop_price")));
		p.setOil(Double.parseDouble(request.getParameter("oil")));
		p.setDisplacement(Double.parseDouble(request.getParameter("displacement")));
		p.setRank(Integer.parseInt(request.getParameter("rank")));
		String cid=request.getParameter("cid");
		CategoryService cs=new CategoryServiceImpl();
		//String cname=cs.findCnameByCid(cid);
		p.setCategory(cid);
		/*if(cid.equals("0"))
		{
			p.setCategory("手机");
		}
		else if(cid.equals("1")){
			p.setCategory("电脑");
		}*/
		//System.out.println(p.getPname()+" "+p.getMarket_price()+" "+p.getShop_price()+" "+p.getPdesc()+" "+p.getCategory());
		ProductService ps= new ProductServiceImpl();
		request.setAttribute("pname",p.getPname());
		boolean status=ps.addProduct(p);
		if(status){
			request.setAttribute("message",p.getPname()+"车辆添加成功!");
			request.getRequestDispatcher("/admin/product/addimage.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message",request.getParameter("pname")+"车辆添加失败!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
	}

}
