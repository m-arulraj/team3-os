package com.example.clientapplication.domain;

import java.sql.Date;

public class OrderDetails {

	long customerfk,productfk;
	String status;
	String date;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
