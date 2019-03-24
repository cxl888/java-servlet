package cn.itcast.demo01_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.demo02_service.ProductService;
import cn.itcast.demo03_serviceImpl.ProductServiceImpl;
import cn.itcast.demo06_domain.Product;

/**
 * EditProductServlet
 */
public class EditProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product p= new Product();
		p.setPid(Integer.parseInt(request.getParameter("pid")));
		p.setPname(request.getParameter("pname"));
		p.setPdesc(request.getParameter("pdesc"));
		p.setMarket_price(Double.parseDouble(request.getParameter("market_price")));
		p.setShop_price(Double.parseDouble(request.getParameter("shop_price")));
		p.setOil(Double.parseDouble(request.getParameter("oil")));
		p.setDisplacement(Double.parseDouble(request.getParameter("displacement")));
		p.setRank(Integer.parseInt(request.getParameter("rank")));
		String cid=request.getParameter("cid");
		/*if(cid.equals("0"))
		{
			p.setCategory("手机");
		}
		else if(cid.equals("1")){
			p.setCategory("电脑");
		}*/
		p.setCategory(cid);
		//System.out.println(p.getPid()+" "+p.getPname()+" "+p.getMarket_price()+" "+p.getShop_price()+" "+p.getPdesc()+" "+p.getCategory());
		ProductService ps= new ProductServiceImpl();
		boolean status=ps.editProduct(p);
		if(status){
			request.setAttribute("pid",p.getPid());
			request.getRequestDispatcher("/admin/product/confirm_editimage.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message","车辆修改失败!");
			request.getRequestDispatcher("/admin/information _cue.jsp").forward(request, response);
		}
	}

}
