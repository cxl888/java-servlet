package cn.itcast.demo03_serviceImpl;

import java.util.List;

import cn.itcast.demo02_service.UserService;
import cn.itcast.demo04_dao.UserDao;
import cn.itcast.demo05_daoImpl.UserDaoImpl;
import cn.itcast.demo06_domain.User;

public class UserServiceImpl implements UserService {

	public void regist(User u) {
		UserDao ud =new UserDaoImpl ();
		ud.insert(u);

	}

	public User findUserByUsername(String username) {
		UserDao ud = new UserDaoImpl();
		
		return ud.findUserByUsername(username);
	}
	
	public void addHistoriesByUsername(String username, String history) {
		UserDao ud = new UserDaoImpl();
		ud.addHistoriesByUsername(username,history);
		
	}

	@Override
	public int findUserTotalCount() {
		UserDao ud = new UserDaoImpl();
		return ud.findUserTotalCount();
	}

	@Override
	public List<User> findAllUser(int startIndex, int pageSize) {
		UserDao ud = new UserDaoImpl();
		return ud.findAllUser(startIndex,pageSize);
	}

	@Override
	public boolean editUser(User u) {
		UserDao ud= new UserDaoImpl();
		return ud.editUser(u);
	}

	@Override
	public boolean delUserByUid(String uid) {
		UserDao ud= new UserDaoImpl();
		return ud.delUserByUid(uid);
	}

}
