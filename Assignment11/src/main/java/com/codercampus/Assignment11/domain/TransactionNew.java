package com.codercampus.Assignment11.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionNew {

	private Long id;
	private LocalDateTime date;
	private String retailer;
	private BigDecimal fundsIn;
	private BigDecimal fundsOut;
	private String type;
	private BigDecimal amount;
	private String description;
	
	public TransactionNew(Long id, LocalDateTime date, String retailer, BigDecimal fundsIn, 
			BigDecimal fundsOut, String type, BigDecimal amount, String description) {
		this.id = id;
		this.date = date;
		this.retailer = retailer;
		this.fundsIn = fundsIn;
		this.fundsOut = fundsOut;
		this.type = type;
		this.amount = amount;
		this.description = description;
	}

	public TransactionNew() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getRetailer() {
		return retailer;
	}
	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}
	public BigDecimal getFundsIn() {
		return fundsIn;
	}
	public void setFundsIn(BigDecimal fundsIn) {
		this.fundsIn = fundsIn;
	}
	public BigDecimal getFundsOut() {
		return fundsOut;
	}
	public void setFundsOut(BigDecimal fundsOut) {
		this.fundsOut = fundsOut;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "TransactionNew [id=" + id + ", date=" + date + ", retailer=" + retailer + ", fundsIn=" + fundsIn
				+ ", fundsOut=" + fundsOut + ", type=" + type + ", amount=" + amount + ", description=" + description+"]";
	}

}
