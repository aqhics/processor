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
 * Country total DTO.
 * 
 * @author Alfredo Quezada
 */
public class CountryTotal implements Serializable {
	
	private static final long serialVersionUID = 1607150462499921334L;

	/**
	 * The country origin of the trades.
	 */
	private String country;
	
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
	 * @param country The country origin of the trades.
	 * @param sellTotal The total for sell amounts.
	 * @param buyTotal The total for buy amounts.
	 * @param transactionCount The amount of trades.
	 */
	public CountryTotal(String country, BigDecimal sellTotal,
			BigDecimal buyTotal, long transactionCount) {
		super();
		this.country = country;
		this.sellTotal = sellTotal;
		this.buyTotal = buyTotal;
		this.transactionCount = transactionCount;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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