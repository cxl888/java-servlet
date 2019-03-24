package cn.itcast.demo02_service;

import java.util.List;



import cn.itcast.demo06_domain.User;

public interface UserService {

	void regist(User u);

	User findUserByUsername(String username);
    void addHistoriesByUsername(String username,String history);
    int findUserTotalCount();
    List<User> findAllUser(int startIndex, int pageSize);

	

	boolean editUser(User u);

	boolean delUserByUid(String uid);
}
