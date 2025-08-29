package model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int userID;
	private String userName;
	private String email;
	private String fullName;
	private String _password;
	private String images;
	private String phone;
	private int status;
	private String code;
	private int roleID;
	private int sellerID;

	public User() {
	}

	public User(int userID, String userName, String email,  String fullName, String _password, String images,String phone, int status,String code,int roleID,int selleID) {
		this.userID = userID;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this._password = _password;
		this.images = images ;
		this.phone = phone;
		this.status=status;
		this.code=code;
		this.roleID=roleID;
		this.sellerID=selleID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String get_password() {
		return _password;
	}

	public void set_password(String _password) {
		this._password = _password;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public int getSellerID() {
		return sellerID;
	}

	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
	

	
	

}

