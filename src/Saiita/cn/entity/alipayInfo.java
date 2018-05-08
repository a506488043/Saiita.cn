package Saiita.cn.entity;



/**
 * 支付宝账单
 */

public class alipayInfo {
	//ID
	int id;
	// 交易号
	String TradeNumber;
	// 商户订单号
	String MerchantOrderNumber;
	// 交易创建时间
	String TransactionCreationTime;
	// 付款时间
	String PaymentTime;
	// 最近修改时间
	String RecentModificationTime;
	// 交易来源地
	String SourceTransation;
	// 类型
	String Type;
	// 交易对方
	String TheDealingParty;
	// 商品名称
	String CommodityName;
	// 金额
	float Amount;
	// 收/支
	String BalanceOfPayments;
	// 交易状态
	String TransationStatus;
	// 服务费
	String TheServiceFee;
	// 成功退款
	String SuccessfulRefund;
	// 备注
	String Remark;
	// 资金状态
	String StateFunding;
	// 支出总统计
	String TotalSpending;
	// 收入总统计
	String TotalRevenue;

	public float getAmount() {
		return Amount;
	}

	public void setAmount(float amount) {
		Amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTotalSpending() {
		return TotalSpending;
	}

	public void setTotalSpending(String totalSpending) {
		TotalSpending = totalSpending;
	}

	public String getTotalRevenue() {
		return TotalRevenue;
	}

	public void setTotalRevenue(String totalRevenue) {
		TotalRevenue = totalRevenue;
	}

	public String getTradeNumber() {
		return TradeNumber;
	}

	public void setTradeNumber(String tradeNumber) {
		TradeNumber = tradeNumber;
	}

	public String getMerchantOrderNumber() {
		return MerchantOrderNumber;
	}

	public void setMerchantOrderNumber(String merchantOrderNumber) {
		MerchantOrderNumber = merchantOrderNumber;
	}

	public String getTransactionCreationTime() {
		return TransactionCreationTime;
	}

	public void setTransactionCreationTime(String transactionCreationTime) {
		TransactionCreationTime = transactionCreationTime;
	}

	public String getPaymentTime() {
		return PaymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		PaymentTime = paymentTime;
	}

	public String getRecentModificationTime() {
		return RecentModificationTime;
	}

	public void setRecentModificationTime(String recentModificationTime) {
		RecentModificationTime = recentModificationTime;
	}

	public String getSourceTransation() {
		return SourceTransation;
	}

	public void setSourceTransation(String sourceTransation) {
		SourceTransation = sourceTransation;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getTheDealingParty() {
		return TheDealingParty;
	}

	public void setTheDealingParty(String theDealingParty) {
		TheDealingParty = theDealingParty;
	}

	public String getCommodityName() {
		return CommodityName;
	}

	public void setCommodityName(String commodityName) {
		CommodityName = commodityName;
	}


	public String getBalanceOfPayments() {
		return BalanceOfPayments;
	}

	public void setBalanceOfPayments(String balanceOfPayments) {
		BalanceOfPayments = balanceOfPayments;
	}

	public String getTransationStatus() {
		return TransationStatus;
	}

	public void setTransationStatus(String transationStatus) {
		TransationStatus = transationStatus;
	}

	public String getTheServiceFee() {
		return TheServiceFee;
	}

	public void setTheServiceFee(String theServiceFee) {
		TheServiceFee = theServiceFee;
	}

	public String getSuccessfulRefund() {
		return SuccessfulRefund;
	}

	public void setSuccessfulRefund(String successfulRefund) {
		SuccessfulRefund = successfulRefund;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getStateFunding() {
		return StateFunding;
	}

	public void setStateFunding(String stateFunding) {
		StateFunding = stateFunding;
	}

}
