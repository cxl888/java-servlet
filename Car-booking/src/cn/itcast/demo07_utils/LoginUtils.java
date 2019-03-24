package cn.itcast.demo07_utils;

import javax.servlet.http.HttpServletRequest;

public class LoginUtils {
    public static boolean isLogin(HttpServletRequest request){
    	Object obj=request.getSession().getAttribute("user");
    	if(obj==null){
    		return false;
    	}
    	return true;		
    }
}
