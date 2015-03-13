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
package com.aquezada.processor.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aquezada.processor.util.JsonDateDeserializer;
import com.aquezada.processor.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Trade entity.
 * 
 * @author Alfredo Quezada
 */
@Entity
@Table(name = "trade")
public class Trade implements Serializable {
	
	private static final long serialVersionUID = 6059751409907610332L;

	/**
	 * Generated id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/**
	 * The user id.
	 */
	@Column(name = "user_id")
	private long userId;
	
	/**
	 * The currency from type.
	 */
	@Column(name = "currency_from")
	private String currencyFrom;
	
	/**
	 * The currency to type
	 */
	@Column(name = "currency_to")
	private String currencyTo;
	
	/**
	 * The sold amount.
	 */
	@Column(name = "amount_sell")
	private BigDecimal amountSell;
	
	/**
	 * The bought amount.
	 */
	@Column(name = "amount_buy")
	private BigDecimal amountBuy;
	
	/**
	 * The exchange rate.
	 */
	@Column(name = "rate")
	private float rate;
	
	/**
	 * The time the trade was placed.
	 */
	@Column(name = "time_placed")
	private Date timePlaced;
	
	/**
	 * The country of origin for the trade.
	 */
	@Column(name = "originating_country")
	private String originatingCountry;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public BigDecimal getAmountSell() {
		return amountSell;
	}

	public void setAmountSell(BigDecimal amountSell) {
		this.amountSell = amountSell;
	}

	public BigDecimal getAmountBuy() {
		return amountBuy;
	}

	public void setAmountBuy(BigDecimal amountBuy) {
		this.amountBuy = amountBuy;
	}

	public float getRate() {
		return rate;
	}
	
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getTimePlaced() {
		return timePlaced;
	}
	
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public void setTimePlaced(Date timePlaced) {
		this.timePlaced = timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}
	
}
