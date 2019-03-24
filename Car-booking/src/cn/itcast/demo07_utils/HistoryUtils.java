package cn.itcast.demo07_utils;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;



public class HistoryUtils {
	public static LinkedList<String> findHistories(HttpServletRequest request,String Imageurl){
		String history=null;
		LinkedList<String> linkedList = new LinkedList<String>();
		String[] entityHistories =null;
		Cookie c[]=request.getCookies();
	    if(c!=null){
	          for(int i=0;i<c.length;i++)
	          {
	        	  if(c[i].getName().equals("history")){
	        		  history=c[i].getValue();
	        	  }
	          }
	     }
	    
	    /*if (history!= null && !"".equals(history)){
	    	entityHistories=history.split("-");
	    	for (int i = 0; i < entityHistories.length; i++) {
	                linkedList.addFirst(entityHistories[i]);
	            }
	    	
	    	//判断linkedList重复
	    	if (!linkedList.contains(Imageurl)) {
	    		linkedList.addFirst(Imageurl);
            }
	    	
	    	// 用户浏览的商品超过7个，保留最近浏览的商品
	        while(linkedList.size()>3) {
	           linkedList.removeLast();
	        }
	    	return linkedList;
	    }else{
	    	linkedList.addFirst(Imageurl);//第一次
	    	return linkedList;
	    }*/
	    if (history!= null && !"".equals(history)){
	    	history=history+"-"+Imageurl;
	    	entityHistories=history.split("-");
	    	
	    	for (int i = 0; i < entityHistories.length; i++) {
	                if(linkedList.contains(entityHistories[i])){  
	                    
	                	linkedList.remove(entityHistories[i]);  
	                	linkedList.addFirst(entityHistories[i]);  
	                }else{  
	                    if(linkedList.size()>=7){  
	                        
	                    	linkedList.removeLast();  
	                    	linkedList.addFirst(entityHistories[i]);  
	                    }else{  
	                        
	                    	linkedList.addFirst(entityHistories[i]);  
	                    }  
	                }  
	            }
	    return linkedList;
	    	
	    }else{
	    	linkedList.addFirst(Imageurl);//第一次
	    	return linkedList;
	    }
	}
}
