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
package com.aquezada.processor.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.aquezada.processor.model.Trade;
import com.aquezada.processor.queue.TradeQueueListener;
import com.aquezada.processor.rest.TradeDeferredResult;

/**
 * Rest controller for exposing the trade services.
 * 
 * @author Alfredo Quezada
 */
@RestController
@RequestMapping("/trade")
public class TradeRestController {
	
	/**
	 * Template for sending messages.
	 */
	@Autowired
	private JmsTemplate jmsTemplate;
	
	/**
	 * Saves the trade.
	 * @param trade The trade.
	 * @return A response for the save operation.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody DeferredResult<Trade> save(@RequestBody Trade trade) {
		final TradeDeferredResult deferredResult = new TradeDeferredResult(trade);
		
		jmsTemplate.convertAndSend(TradeQueueListener.TRADE_QUEUE, deferredResult);
		
		return deferredResult;
	}
	
}
