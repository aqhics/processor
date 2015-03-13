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
package com.aquezada.processor.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.util.CollectionUtils;

import com.aquezada.processor.dto.CountryTotal;
import com.aquezada.processor.dto.CurrencyPairTotal;
import com.aquezada.processor.service.TradeService;

/**
 * Main controller for showing trade totals.
 * 
 * @author Alfredo Quezada
 */
@ManagedBean
@ViewScoped
public class TradeController implements Serializable {
	
	private static final long serialVersionUID = 1019048927570809946L;
	
	/**
	 * The trade service.
	 */
	@ManagedProperty(value="#{tradeService}")
	private TradeService tradeService;
	
	/**
	 * A list of currency pair totals.
	 */
	private List<CurrencyPairTotal> currencyPairTotals;
	
	/**
	 * A list of country totals.
	 */
	private List<CountryTotal> countryTotals;
	
	/**
	 * Bar chart model for currency pairs.
	 */
	private BarChartModel currencyPairBarModel;
	
	/**
	 * Pie chart model for currency pairs.
	 */
	private PieChartModel currencyPairPieModel;
	
	/**
	 * Pie chart model for countries.
	 */
	private PieChartModel countryPieModel;
	
	/**
	 * Gets the initial data.
	 */
	@PostConstruct
	private void init() {
        getData();
	}
	
	/**
	 * Gets the data for the view.
	 */
	public void getData() {
		currencyPairTotals = tradeService.getTotalByCurrencyPair();
		countryTotals = tradeService.getTotalByCountry();
		
		createCurrencyPairBarModel();
		createCurrencyPairPieModel();
		createCountryModel();
	}
	
	/**
	 * Creates bar chart model for the currency pair.
	 */
	private void createCurrencyPairBarModel() {
		currencyPairBarModel = new BarChartModel();
		
		ChartSeries sold = new ChartSeries();
        ChartSeries bought = new ChartSeries();
        
        sold.setLabel("Sold");
        bought.setLabel("Bought");
        
        for(CurrencyPairTotal total : currencyPairTotals) {
        	final String label = total.getCurrencyFrom() + "/" + total.getCurrencyTo();
        	sold.set(label, total.getSellTotal());
        	bought.set(label, total.getBuyTotal());
        }
        
        currencyPairBarModel.addSeries(sold);
        currencyPairBarModel.addSeries(bought);
        
        currencyPairBarModel.setLegendPosition("ne");
        currencyPairBarModel.setTitle("Trades by Currency Pair");
         
        Axis xAxis = currencyPairBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Currency Pairs");
        
        Axis yAxis = currencyPairBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Amount");
	}
	
	/**
	 * Creates pie chart model for the currency pair.
	 */
	private void createCurrencyPairPieModel() {
		currencyPairPieModel = new PieChartModel();
		
		if(!CollectionUtils.isEmpty(currencyPairTotals)) {
			for(CurrencyPairTotal total : currencyPairTotals) {
				final String label = total.getCurrencyFrom() + "/" + total.getCurrencyTo();
				currencyPairPieModel.set(label, total.getTransactionCount());
			}
		}
         
        currencyPairPieModel.setTitle("Total Trades by Currency Pair");
        currencyPairPieModel.setLegendPosition("ne");
	}
	
	/**
	 * Creates pie chart model for the countries.
	 */
	private void createCountryModel() {
		countryPieModel = new PieChartModel();
		
		if(!CollectionUtils.isEmpty(countryTotals)) {
			for(CountryTotal total : countryTotals) {
				final String label = total.getCountry();
				countryPieModel.set(label, total.getTransactionCount());
			}
		}
		
		countryPieModel.setTitle("Total Trades by Country");
		countryPieModel.setLegendPosition("ne");
	}
	

	/**
	 * Sets the trade service.
	 * @param tradeService The trade service.
	 */
	public void setTradeService(TradeService tradeService) {
		this.tradeService = tradeService;
	}

	public List<CurrencyPairTotal> getCurrencyPairTotals() {
		return currencyPairTotals;
	}
	
	public List<CountryTotal> getCountryTotals() {
		return countryTotals;
	}
	
	public BarChartModel getCurrencyPairBarModel() {
		return currencyPairBarModel;
	}

	public PieChartModel getCurrencyPairPieModel() {
		return currencyPairPieModel;
	}

	public PieChartModel getCountryPieModel() {
		return countryPieModel;
	}
	
}
