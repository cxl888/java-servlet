package cn.itcast.demo02_service;

import java.util.List;

import cn.itcast.demo06_domain.OrderItem;
import cn.itcast.demo06_domain.Orders;
import cn.itcast.demo06_domain.User;

public interface OrderService {

	void saveOrders(Orders o);

	void saveOrderItem(OrderItem oi);

	void updateOrderStatus(String oid, int i);

	List<Orders> findAllOrdersByUserServlet(User u);

	void delOrderAndOrderItem(String oid);

	int findTotalCountByOrders(User u);

	List<Orders> findAllOrdersByUserServlet(int startIndex, int pageSize, User u);

	

	int findOrderTotalCount();

	List<Orders> findAllOrders(int startIndex, int pageSize);

	OrderItem findOrderItemByOid(String oid);

	List<Orders> findAllOidsByUid(String uid);

	
}
