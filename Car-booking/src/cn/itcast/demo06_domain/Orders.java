package cn.itcast.demo06_domain;

import java.util.List;

public class Orders {
    private String oid;
    private double totalmoney;
    private String ordertime;
    private int orderstatus;//1订单创建,2订单付款,3订单完成
    private String name;
    private String phone;
    private String address;
    private int uid;
    //该订单所属用户
    private User user;
    private List<OrderItem> list;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public double getTotalmoney() {
		return totalmoney;
	}
	public void setTotalmoney(double totalmoney) {
		this.totalmoney = totalmoney;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getList() {
		return list;
	}
	public void setList(List<OrderItem> list) {
		this.list = list;
	}
}
