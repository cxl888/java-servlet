package cn.itcast.demo06_domain;

public class OrderItem {
   private int oiid;
   private int pnum;
   private double subtotal;
   private Product product;
   private int pid;
   public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
private String oid;
public int getOiid() {
	return oiid;
}
public void setOiid(int oiid) {
	this.oiid = oiid;
}
public int getPnum() {
	return pnum;
}
public void setPnum(int pnum) {
	this.pnum = pnum;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}

public String getOid() {
	return oid;
}
public void setOid(String oid) {
	this.oid = oid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
}
