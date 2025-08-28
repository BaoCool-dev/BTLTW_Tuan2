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
		if (user != null && user.getPassWord().equals(password)) {
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

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		User user = new User(0, username, password, email, fullname, phone, 0, phone, date);
		// chỉnh lại constructor User cho đúng thứ tự

		return userDao.insert(user); // phải return kết quả từ DAO
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
