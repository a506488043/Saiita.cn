package Saiita.cn.entity;

import java.util.Date;



public class UserInfo {
	/**
	 * �û���Ϣ User��
	 */
	// �û���
	private String Username;
	// ����
	private String Password;
	// id
	private int id;
	// ��½ʧ�ܴ���
	private int Loginfailure;
	// ��½�ɹ�����
	private int LoginSuccess;
	// �û��ȼ���Ȩ��
	private int role;
	// �˺Ŵ���ʱ��
	private String  creatime;
	// �û��ϴε�½ʱ��
	private String  lastLoginTime;
    //��½ʧ��ʱ��
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
