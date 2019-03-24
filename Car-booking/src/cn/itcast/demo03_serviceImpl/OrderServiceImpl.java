package cn.itcast.demo03_serviceImpl;

import java.util.List;

import cn.itcast.demo02_service.OrderService;
import cn.itcast.demo04_dao.OrderDao;
import cn.itcast.demo05_daoImpl.OrderDaoImpl;
import cn.itcast.demo06_domain.OrderItem;
import cn.itcast.demo06_domain.Orders;
import cn.itcast.demo06_domain.User;

public class OrderServiceImpl implements OrderService {

	public void saveOrders(Orders o) {
		OrderDao dao = new OrderDaoImpl();
		dao.saveOrders(o);

	}

	public void saveOrderItem(OrderItem oi) {
		OrderDao dao = new OrderDaoImpl();
		dao.saveOrderItem(oi);
		
	}

	public void updateOrderStatus(String oid, int i) {
		OrderDao dao = new OrderDaoImpl();
		dao.updateOrderStatus(oid,i);
	}

	public List<Orders> findAllOrdersByUserServlet(User u) {
		OrderDao dao = new OrderDaoImpl();
		
		return dao.findAllOrdersByUserServlet(u);
	}

	public void delOrderAndOrderItem(String oid) {
		//先删除订单项,再删除订单
		OrderDao dao = new OrderDaoImpl();
		dao.delOrderAndOrderItem(oid);
		
	}

	
	public int findTotalCountByOrders(User u) {
		OrderDao dao = new OrderDaoImpl();
		return dao.findTotalCountByOrders(u);
	}

	
	public List<Orders> findAllOrdersByUserServlet(int startIndex, int pageSize, User u) {
		OrderDao dao = new OrderDaoImpl();
		return dao.findAllOrdersByUserServlet(startIndex,pageSize,u);
	}

	@Override
	public int findOrderTotalCount() {
		OrderDao dao = new OrderDaoImpl();
		return dao.findOrderTotalCount();
	}

	@Override
	public List<Orders> findAllOrders(int startIndex, int pageSize) {
		OrderDao dao = new OrderDaoImpl();
		return dao.findAllOrders(startIndex,pageSize);
	}

	@Override
	public OrderItem findOrderItemByOid(String oid) {
		OrderDao dao = new OrderDaoImpl();
		return dao.findOrderItemByOid(oid);
	}

	@Override
	public List<Orders> findAllOidsByUid(String uid) {
		OrderDao dao = new OrderDaoImpl();
		return dao.findAllOidsByUid(uid);
	}

	

}
