package Saiita.cn.entity;

import java.math.BigDecimal;

public class creditCard {
	int id;
	// ����
	String nper;
	// ����
	String rate;
	// ÿ�ڱ���
	BigDecimal Each_of_the_principal;
	// ����������
	BigDecimal Single_handling_charge;
	// ����+������
	BigDecimal Principal_handling_fee;
	// ÿ��������
	BigDecimal Daily_handling_charge;
	// ��������
	BigDecimal total_fee;

	public String getNper() {
		return nper;
	}

	public void setNper(String nper) {
		this.nper = nper;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public BigDecimal getEach_of_the_principal() {
		return Each_of_the_principal;
	}

	public void setEach_of_the_principal(BigDecimal each_of_the_principal) {
		Each_of_the_principal = each_of_the_principal;
	}

	public BigDecimal getSingle_handling_charge() {
		return Single_handling_charge;
	}

	public void setSingle_handling_charge(BigDecimal single_handling_charge) {
		Single_handling_charge = single_handling_charge;
	}

	public BigDecimal getPrincipal_handling_fee() {
		return Principal_handling_fee;
	}

	public void setPrincipal_handling_fee(BigDecimal principal_handling_fee) {
		Principal_handling_fee = principal_handling_fee;
	}

	public BigDecimal getDaily_handling_charge() {
		return Daily_handling_charge;
	}

	public void setDaily_handling_charge(BigDecimal daily_handling_charge) {
		Daily_handling_charge = daily_handling_charge;
	}

	public BigDecimal getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
