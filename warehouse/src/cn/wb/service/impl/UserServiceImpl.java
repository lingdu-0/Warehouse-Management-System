package cn.wb.service.impl;

import java.util.List;

import cn.wb.dao.UserDao;
import cn.wb.dao.impl.UserDaoImpl;
import cn.wb.entity.User;
import cn.wb.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao dao = new UserDaoImpl();

	@Override
	public List<User> listUser() {		
		return dao.listUser();
	}

	@Override
	public int addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public int deleteUser(int uid) {
		return dao.deleteUser(uid);
	}

	@Override
	public int modifyUser(User user) {
		return dao.modifyUser(user);
	}

	@Override
	public User login(User user) {
		return dao.getUser(user);
	}

}
