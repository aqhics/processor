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

import com.aquezada.processor.dto.CountryTotal;
import com.aquezada.processor.dto.CurrencyPairTotal;
import com.aquezada.processor.model.Trade;

/**
 * Trade service interface.
 * 
 * @author Alfredo Quezada
 */
public interface TradeService {
	
	/**
	 * Gets the total trade amounts by country.
	 * @return A list of CountryTotal.
	 */
	List<CountryTotal> getTotalByCountry();
	
	/**
	 * Gets the total trade amounts by currency pair.
	 * @return A list of CurrencyPairTotal.
	 */
	List<CurrencyPairTotal> getTotalByCurrencyPair();
	
	/**
	 * Saves a trade.
	 * @param trade The trade entity.
	 * @return The saved trade.
	 */
	Trade save(Trade trade);
}
