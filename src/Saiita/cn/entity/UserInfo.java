package Saiita.cn.entity;

import java.util.Date;



public class UserInfo {
	/**
	 * 用户信息 User表
	 */
	// 用户名
	private String Username;
	// 密码
	private String Password;
	// id
	private int id;
	// 登陆失败次数
	private int Loginfailure;
	// 登陆成功次数
	private int LoginSuccess;
	// 用户等级，权限
	private int role;
	// 账号创建时间
	private String  creatime;
	// 用户上次登陆时间
	private String  lastLoginTime;
    //登陆失败时间
	private String LoginfailureDate;

	

	public String getCreatime() {
		return creatime;
	}

	public void setCreatime(String creatime) {
		this.creatime = creatime;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLoginfailureDate() {
		return LoginfailureDate;
	}

	public void setLoginfailureDate(String loginfailureDate) {
		LoginfailureDate = loginfailureDate;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLoginfailure() {
		return Loginfailure;
	}

	public void setLoginfailure(int loginfailure) {
		Loginfailure = loginfailure;
	}

	public int getLoginSuccess() {
		return LoginSuccess;
	}

	public void setLoginSuccess(int loginSuccess) {
		LoginSuccess = loginSuccess;
	}


}
