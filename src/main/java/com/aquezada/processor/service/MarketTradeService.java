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
package com.aquezada.processor.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.transaction.annotation.Transactional;

import com.aquezada.processor.dao.TradeDao;
import com.aquezada.processor.dto.CountryTotal;
import com.aquezada.processor.dto.CurrencyPairTotal;
import com.aquezada.processor.model.Trade;

/**
 * Trade entity.
 * 
 * @author Alfredo Quezada
 */
@Transactional
public class MarketTradeService implements TradeService {
	
	private final Logger log = Logger.getLogger(MarketTradeService.class);
	
	/**
	 * Dao for obtaining data.
	 */
	private TradeDao tradeDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CountryTotal> getTotalByCountry() {
		try {
			return tradeDao.getTotalByCountry();
		} catch(HibernateException ex) {
			log.error("Error getting total by country.", ex);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CurrencyPairTotal> getTotalByCurrencyPair() {
		try {
			return tradeDao.getTotalByCurrencyPair();
		} catch(HibernateException ex) {
			log.error("Error getting total by currency pair.", ex);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Trade save(Trade trade) {
		try {
			return tradeDao.save(trade);
		} catch(HibernateException ex) {
			log.error("Error saving transaction.", ex);
		}
		return null;
	}

	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

}
