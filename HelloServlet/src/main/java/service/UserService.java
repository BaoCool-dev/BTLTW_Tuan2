package service;

import model.User;

public interface UserService {
	User login(String userName, String _password);

	User get(String userName);

	void insert(User user);

	boolean register(String email, String _password, String userName, String fullName, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
}
