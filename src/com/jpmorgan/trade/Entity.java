package com.jpmorgan.trade;

import java.util.Date;

public class Entity {
	
	private String entityName;
	private String buy_or_sell;
	private Double agreedFx;
	private String currency;
	private Date instructionDate;
	private Date settlementDate;
	private Integer units;
	private Double pricePerUnit;
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getBuy_or_sell() {
		return buy_or_sell;
	}
	public void setBuy_or_sell(String buy_or_sell) {
		this.buy_or_sell = buy_or_sell;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public Integer getUnits() {
		return units;
	}
	public void setUnits(Integer units) {
		this.units = units;
	}
	public Double getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(Double agreedFx) {
		this.agreedFx = agreedFx;
	}
	public Double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	

}
