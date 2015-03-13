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
package com.aquezada.processor.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;

import com.aquezada.processor.model.Trade;
import com.aquezada.processor.rest.TradeDeferredResult;
import com.aquezada.processor.service.TradeService;

/**
 * Listener for message queues.
 * 
 * @author Alfredo Quezada
 */
public class TradeQueueListener implements MessageListener {

	public static final String TRADE_QUEUE = "TradeQueue";
	
	private final Logger log = Logger.getLogger(TradeQueueListener.class);
	
	/**
	 * Trade service for saving.
	 */
	private TradeService tradeService;
	
	@Override
	public void onMessage(final Message message) {
		if(message instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage)message;
				try {
					if(objectMessage.getObject() instanceof TradeDeferredResult) {
						final TradeDeferredResult deferredResult = (TradeDeferredResult) objectMessage.getObject();
						if(deferredResult.getTrade() != null) {
							final Trade trade = tradeService.save(deferredResult.getTrade());
							
							if(!deferredResult.isSetOrExpired()) {
								deferredResult.setResult(trade);
							}
						} else {
							if(!deferredResult.isSetOrExpired()) {
								deferredResult.setResult(null);
							}
						}
					} else {
						log.debug("Message object type is not TradeDeferredResult");
					}
				} catch (JMSException ex) {
					log.error("Error getting trade from message.", ex);
				}
		} else {
			log.debug("Message type is not Object");
		}
	}

	public void setTradeService(TradeService tradeService) {
		this.tradeService = tradeService;
	}
	
}
