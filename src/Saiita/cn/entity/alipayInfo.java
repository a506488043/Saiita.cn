package Saiita.cn.entity;



/**
 * ֧�����˵�
 */

public class alipayInfo {
	//ID
	int id;
	// ���׺�
	String TradeNumber;
	// �̻�������
	String MerchantOrderNumber;
	// ���״���ʱ��
	String TransactionCreationTime;
	// ����ʱ��
	String PaymentTime;
	// ����޸�ʱ��
	String RecentModificationTime;
	// ������Դ��
	String SourceTransation;
	// ����
	String Type;
	// ���׶Է�
	String TheDealingParty;
	// ��Ʒ����
	String CommodityName;
	// ���
	float Amount;
	// ��/֧
	String BalanceOfPayments;
	// ����״̬
	String TransationStatus;
	// �����
	String TheServiceFee;
	// �ɹ��˿�
	String SuccessfulRefund;
	// ��ע
	String Remark;
	// �ʽ�״̬
	String StateFunding;
	// ֧����ͳ��
	String TotalSpending;
	// ������ͳ��
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
