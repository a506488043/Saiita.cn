package Saiita.cn.entity;

public class JsonResult<T> {
	private String EncryptionExponent;
	private String Modulus;
	private T data;

	public String getEncryptionExponent() {
		return EncryptionExponent;
	}

	public void setEncryptionExponent(String encryptionExponent) {
		EncryptionExponent = encryptionExponent;
	}

	public String getModulus() {
		return Modulus;
	}

	public void setModulus(String modulus) {
		Modulus = modulus;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
