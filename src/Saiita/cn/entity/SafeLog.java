package Saiita.cn.entity;

public class SafeLog {
	// �û���
	String username;
	// ����ʱ��
	String datetime;
	// ��־����
	String operation;
	// ���
	String result;
	// ��ȫ��־����
	String safetylog;
	// ����IP
	String ip;
	// ���������
	String browser;
	// �����
	String BrowserType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getSafetylog() {
		return safetylog;
	}

	public void setSafetylog(String safetylog) {
		this.safetylog = safetylog;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getBrowserType() {
		return BrowserType;
	}

	public void setBrowserType(String browserType) {
		BrowserType = browserType;
	}

}
