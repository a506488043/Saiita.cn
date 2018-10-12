package Saiita.cn.entity;

import java.math.BigDecimal;

public class creditCard {
	String id;
	//期数
	int nper;
	//费率
	String rate;
	//每期本金
	BigDecimal Each_of_the_principal;
	//单期手续费
	BigDecimal Single_handling_charge;
	//本金+手续费
	BigDecimal Principal_handling_fee;
	public int getNper() {
		return nper;
	}

	public void setNper(int nper) {
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

	public float getDaily_handling_charge() {
		return Daily_handling_charge;
	}

	public void setDaily_handling_charge(float daily_handling_charge) {
		Daily_handling_charge = daily_handling_charge;
	}

	public float getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(float total_fee) {
		this.total_fee = total_fee;
	}

	//每日手续费
	float Daily_handling_charge;
	//总手续费
	float total_fee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	


}
