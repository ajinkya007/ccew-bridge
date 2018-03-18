package com.citib.arbitrage.model;

public class SavedStock 
{
	 public String stockName,date,time,userId;
	 public double nsePrice,bsePrice,profit;
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getNsePrice() {
		return nsePrice;
	}
	public void setNsePrice(double nsePrice) {
		this.nsePrice = nsePrice;
	}
	public double getBsePrice() {
		return bsePrice;
	}
	public void setBsePrice(double bsePrice) {
		this.bsePrice = bsePrice;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
