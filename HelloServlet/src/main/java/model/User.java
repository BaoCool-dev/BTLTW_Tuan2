package model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int userID;
	private String email;
	private String userName;
	private String fullName;
	private String _passWord;
	private String avatar;
	private int roleid;
	private String phone;
	private Date createdDate;

	public User() {
	}

	public User(int userID, String email, String userName, String fullName, String _passWord, String avatar, int roleid,
			String phone, Date createdDate) {
		this.userID = userID;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this._passWord = _passWord;
		this.avatar = avatar ;
		this.roleid = roleid;
		this.phone = phone;
		this.createdDate = createdDate;
	}
	

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID= userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassWord() {
		return _passWord;
	}

	public void setPassWord(String _passWord) {
		this._passWord = _passWord;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	

}

