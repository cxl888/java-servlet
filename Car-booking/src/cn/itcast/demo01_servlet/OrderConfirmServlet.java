package cn.itcast.demo01_servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mysql.fabric.xmlrpc.base.Data;

import cn.itcast.demo02_service.OrderService;
import cn.itcast.demo03_serviceImpl.OrderServiceImpl;
import cn.itcast.demo06_domain.Cart;
import cn.itcast.demo06_domain.CartItem;
import cn.itcast.demo06_domain.OrderItem;
import cn.itcast.demo06_domain.Orders;
import cn.itcast.demo06_domain.Product;
import cn.itcast.demo06_domain.User;
import cn.itcast.demo07_utils.LoginUtils;
import cn.itcast.demo07_utils.UUIDUtils;

/**
 * OrderConfirmServlet
 * 1.判断是否登录
 * 2.获得jsp传的参数
 * 3.从session中获得购物车信息
 * 4.清空购物车
 * 5.将订单对象保存到request域中
 * 6.跳转到订单支付的详情页面
 */
public class OrderConfirmServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean b=LoginUtils.isLogin(request);
		if(b){//继续
			User u=(User)request.getSession().getAttribute("user");
			//2.获得jsp传的参数
			Orders o=new Orders();
			Map<String,String[]> map=request.getParameterMap();
			try {
			   BeanUtils.populate(o, map);
			   String uuid=UUIDUtils.getUUID();
			   o.setOid(uuid);
			   Object obj=request.getSession().getAttribute("cart");
			   if(obj==null){
				   request.setAttribute("msg", "您还没有租车!");
				   request.getRequestDispatcher("/FindProductByCategoryName").forward(request, response);
				   return;
			   }
			   //强转购物车
			   Cart c=(Cart)obj;
			   double money=c.getTotalMoney();
			   o.setTotalmoney(money);
			   String time=new Date().toLocaleString();
			   o.setOrdertime(time);
			   o.setOrderstatus(1);
			   o.setUser(u);
			   //需要将订单对象存到数据库
			   OrderService os=new OrderServiceImpl();
			   os.saveOrders(o);
			   
			   //从购物车中获取购物项map
			   Map<String,CartItem> map2=c.getMap();
			   //获取所有购物项并转为订单项
			   Collection<CartItem> values=map2.values();
			   List<OrderItem> list=new ArrayList<OrderItem>();
			   for(CartItem ci:values){
				   //ci为每一个购物项
				   int count=ci.getCount();
				   OrderItem oi=new OrderItem();
				   oi.setPnum(count);
				   double d=ci.getSubtotal();
				   oi.setSubtotal(d);
				   Product p=ci.getProduct();
				   oi.setProduct(p);
				   oi.setOid(uuid);
				   //需要将订单项存到数据库
				   os.saveOrderItem(oi);
				   list.add(oi);
			   }
			   //再循环结束后,将list集合保存到订单对象中
			   o.setList(list);
			   //清空购物车
			   request.getSession().removeAttribute("cart");
			   //5.将订单对象保存到request域中
			   request.setAttribute("orders", o);
			   request.getRequestDispatcher("/jsp/order_pay.jsp").forward(request, response);
			} 
			catch (Exception e) {
				e.printStackTrace();
				} 
		 }
		else{//提醒
			request.setAttribute("msg", "先登录,再租车!");
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
