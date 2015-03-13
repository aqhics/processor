/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aquezada.processor.dto;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * Currency total DTO.
 * 
 * @author Alfredo Quezada
 */

public class CurrencyPairTotal implements Serializable {
	
	private static final long serialVersionUID = 3463630957478132240L;
	
	/**
	 * The currency from type of the trade.
	 */
	private String currencyFrom;
	
	/**
	 * The currency to type of the trade.
	 */
	private String currencyTo;
	
	/**
	 * The total for sell amounts.
	 */
	private BigDecimal sellTotal;
	
	/**
	 * The total for buy amounts.
	 */
	private BigDecimal buyTotal;

	/**
	 * The amount of trades.
	 */
	private long transactionCount;

	/**
	 * Contructor.
	 * @param currencyFrom The currency from type of the trade.
	 * @param currencyTo The currency to type of the trade.
	 * @param sellTotal The total for sell amounts.
	 * @param buyTotal The total for buy amounts.
	 * @param transactionCount The amount of trades.
	 */
	public CurrencyPairTotal(String currencyFrom,
			String currencyTo, BigDecimal sellTotal, BigDecimal buyTotal,
			long transactionCount) {
		super();
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.sellTotal = sellTotal;
		this.buyTotal = buyTotal;
		this.transactionCount = transactionCount;
	}
	

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public BigDecimal getSellTotal() {
		return sellTotal;
	}

	public void setSellTotal(BigDecimal sellTotal) {
		this.sellTotal = sellTotal;
	}

	public BigDecimal getBuyTotal() {
		return buyTotal;
	}

	public void setBuyTotal(BigDecimal buyTotal) {
		this.buyTotal = buyTotal;
	}

	public long getTransactionCount() {
		return transactionCount;
	}

	public void setTransactionCount(long transactionCount) {
		this.transactionCount = transactionCount;
	}
	
}