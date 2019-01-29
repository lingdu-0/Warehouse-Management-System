package cn.wb.service;

import java.util.List;
import cn.wb.entity.User;

public interface UserService {
	
	/**登录*/
	User login(User user);
	
	/** 查询全部用户 */
	List<User> listUser();

	/** 添加用户 */
	int addUser(User user);
	
	/**删除用户*/
	int deleteUser(int uid);
	
	/**修改用户信息*/	
	int modifyUser(User user);
}
