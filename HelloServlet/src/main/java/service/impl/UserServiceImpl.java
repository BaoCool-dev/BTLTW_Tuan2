package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = userDao.get(username);
		if (user != null && user.get_password().equals(password)) {
			return user;
		}
		return null;
	}

	@Override
	public User get(String username) {
		return userDao.get(username);
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {
		if (userDao.checkExistUsername(username)) {
			return false;
		}
		 User user = new User();
		    user.setUserName(username);
		    user.set_password(password);
		    user.setEmail(email);
		    user.setFullName(fullname);
		    user.setPhone(phone);

		    // Gán các giá trị mặc định
		    user.setImages("default.png");
		    user.setStatus(1);
		    user.setCode(generateRandomCode());
		    user.setRoleID(2);    // 2 = khách hàng
		    user.setSellerID(0);  // chưa là seller
		    return userDao.insert(user);
		 
		// chỉnh lại constructor User cho đúng thứ tự

	}

	private String generateRandomCode() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

}
