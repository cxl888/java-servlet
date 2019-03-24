package cn.itcast.demo06_domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/*
 * 购物车
 */
public class Cart {
    private Map<String,CartItem> map= new HashMap<String,CartItem>();
    public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	private double totalMoney;
    //计算总金额
    public double getTotalMoney(){
		//单列集合
    	Collection<CartItem> values=map.values();
		
    	double money=0.0;
    	for(CartItem it:values){
    		money+=it.getSubtotal();
    	}
    	return money;
    	
    }
    //购物车添加商品方法
    
    public void addProductToCart(Product p,int num){
    	int pid=p.getPid();
    	CartItem item=null;
    	if(map.containsKey(pid+"")){
    		item=map.get(pid+"");//?
    	}
    	else{
    		item=new CartItem();
    	}
    	int newCount =item.getCount()+num;
    	item.setCount(newCount);
    	item.setProduct(p);
    	map.put(pid+"",item);
    }
    //根据商品id,删除购物项
    public void removeProductByid(String pid){
    	map.remove(pid);
    }
	
}
