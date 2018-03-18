package com.citib.arbitrage.model;

public class CurrentStock
{
	String stockName,recommendation;
	double bsePrice,nsePrice,profit;
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}
	public double getBsePrice() {
		return bsePrice;
	}
	public void setBsePrice(double bsePrice) {
		this.bsePrice = bsePrice;
	}
	public double getNsePrice() {
		return nsePrice;
	}
	public void setNsePrice(double nsePrice) {
		this.nsePrice = nsePrice;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}

}
