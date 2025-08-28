package dao;

import model.User;

public interface UserDao {
	User get(String userName);

	boolean insert(User user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

}
