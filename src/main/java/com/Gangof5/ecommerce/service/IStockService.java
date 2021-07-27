package com.Gangof5.ecommerce.service;

import java.util.List;


import com.Gangof5.ecommerce.model.Stock;

public interface IStockService {

	List<Stock> getStocks (int b);
	Stock getStock (int s);
	int countStocks (int b);
	Stock createStock(Stock s);
	Stock updateStock(Stock s);
	void deleteStock(int s);
	
}
