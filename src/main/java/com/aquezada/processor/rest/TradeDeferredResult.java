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
package com.aquezada.processor.rest;

import java.io.Serializable;

import org.springframework.web.context.request.async.DeferredResult;

import com.aquezada.processor.model.Trade;

/**
 * Deferred result for trades with serialization.
 * 
 * @author Alfredo Quezada
 */
public class TradeDeferredResult extends DeferredResult<Trade> implements Serializable {
	
	private static final long serialVersionUID = 6799265936047505853L;
	
	/**
	 * The trade.
	 */
	private Trade trade;
	
	/**
	 * Contructor.
	 * @param trade The trade.
	 */
	public TradeDeferredResult(Trade trade) {
		super();
		this.trade = trade;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	
}
