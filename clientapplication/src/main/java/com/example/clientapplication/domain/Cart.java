package com.example.clientapplication.domain;


public class Cart {

	long customerfk,productfk;

	public long getCustomerfk() {
		return customerfk;
	}

	public void setCustomerfk(long customerfk) {
		this.customerfk = customerfk;
	}

	public long getProductfk() {
		return productfk;
	}

	public void setProductfk(long productfk) {
		this.productfk = productfk;
	}
	
}
