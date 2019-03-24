package cn.itcast.demo06_domain;
/*
 * 购物项
 */
public class CartItem {
   private Product product;
   private int count;
   private double subtotal;
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public double getSubtotal(){
	if(product==null){
		return 0;
	}
	return product.getShop_price()*count;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
}
