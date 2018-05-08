package Saiita.cn.entity;

public class alipayStatisticsInfo {
	//总支出笔数
	int totalDisbursement;
	//总支出金额
	float totalExpenditure;
	//总收入笔数
	int totalRevenue;
	//总收入金额
	float grossIncome;
	//信用卡透支
	float creditCardOverdraft;
	//逆差
    float deficit;
    //项目
    String projects;
    //id
    int id;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	public int getTotalDisbursement() {
		return totalDisbursement;
	}
	public void setTotalDisbursement(int totalDisbursement) {
		this.totalDisbursement = totalDisbursement;
	}
	public float getTotalExpenditure() {
		return totalExpenditure;
	}
	public void setTotalExpenditure(float totalExpenditure) {
		this.totalExpenditure = totalExpenditure;
	}
	public int getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	public float getGrossIncome() {
		return grossIncome;
	}
	public void setGrossIncome(float grossIncome) {
		this.grossIncome = grossIncome;
	}
	public float getCreditCardOverdraft() {
		return creditCardOverdraft;
	}
	public void setCreditCardOverdraft(float creditCardOverdraft) {
		this.creditCardOverdraft = creditCardOverdraft;
	}
	public float getDeficit() {
		return deficit;
	}
	public void setDeficit(float deficit) {
		this.deficit = deficit;
	}
    
    
}
