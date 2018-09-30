package Saiita.cn.entity;

public class creditCard {
	String id;
	//期数
	String nper;
	//费率
	String rate;
	//每期本金
	String Each_of_the_principal;
	//单期手续费
	String Single_handling_charge;
	//本金+手续费
	String Principal_handling_fee;
	//每日手续费
	String Daily_handling_charge;
	//总手续费
	String total_fee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getEach_of_the_principal() {
		return Each_of_the_principal;
	}

	public void setEach_of_the_principal(String each_of_the_principal) {
		Each_of_the_principal = each_of_the_principal;
	}

	public String getSingle_handling_charge() {
		return Single_handling_charge;
	}

	public void setSingle_handling_charge(String single_handling_charge) {
		Single_handling_charge = single_handling_charge;
	}

	public String getPrincipal_handling_fee() {
		return Principal_handling_fee;
	}

	public void setPrincipal_handling_fee(String principal_handling_fee) {
		Principal_handling_fee = principal_handling_fee;
	}

	public String getDaily_handling_charge() {
		return Daily_handling_charge;
	}

	public void setDaily_handling_charge(String daily_handling_charge) {
		Daily_handling_charge = daily_handling_charge;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

}
