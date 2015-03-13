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
package com.aquezada.processor.dao;

import java.util.List;

import org.hibernate.Query;

import com.aquezada.processor.dto.CountryTotal;
import com.aquezada.processor.dto.CurrencyPairTotal;
import com.aquezada.processor.model.Trade;

/**
 * Trade DAO for obtaining total result in DTO objects.
 * 
 * @author Alfredo Quezada
 */
public class TradeDao extends GenericHibernateDao<Trade, Long> {
	
	/**
	 * Currency pair total query.
	 */
	private final String CURRENCY_PAIR_TOTAL_QUERY = "SELECT new " + CurrencyPairTotal.class.getCanonicalName()
			+ "(o.currencyFrom, o.currencyTo, SUM(o.amountSell) AS sellTotal, SUM(o.amountBuy), COUNT(o)) "
			+ " FROM Trade o "
			+ " GROUP BY o.currencyFrom, o.currencyTo "
			+ " ORDER BY sellTotal DESC ";
	
	/**
	 * Country total query.
	 */
	private final String COUNTRY_TOTAL_QUERY = "SELECT new " + CountryTotal.class.getCanonicalName()
			+ "(o.originatingCountry, SUM(o.amountSell), SUM(o.amountBuy), COUNT(o)) "
			+ " FROM Trade o "
			+ " GROUP BY o.originatingCountry "
			+ " ORDER BY o.originatingCountry ";
	
	/**
	 * Obtains a list of totals by Currency Pair.
	 * @return A list of CurrencyPairTotal.
	 */
	@SuppressWarnings("unchecked")
	public List<CurrencyPairTotal> getTotalByCurrencyPair() {
		final Query query = getSession().createQuery(CURRENCY_PAIR_TOTAL_QUERY);
		return query.list();
	}
	
	/**
	 * Obtains a list of totals by Country.
	 * @return A list of CountryTotal.
	 */
	@SuppressWarnings("unchecked")
	public List<CountryTotal> getTotalByCountry() {
		final Query query = getSession().createQuery(COUNTRY_TOTAL_QUERY);
		return query.list();
	}
}
