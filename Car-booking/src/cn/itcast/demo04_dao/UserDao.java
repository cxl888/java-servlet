package cn.itcast.demo04_dao;

import java.util.List;

import cn.itcast.demo06_domain.User;

public interface UserDao {

	void insert(User u);

	User findUserByUsername(String username);

	void addHistoriesByUsername(String username, String history);

	int findUserTotalCount();

	List<User> findAllUser(int startIndex, int pageSize);

	boolean editUser(User u);

	boolean delUserByUid(String uid);

}
