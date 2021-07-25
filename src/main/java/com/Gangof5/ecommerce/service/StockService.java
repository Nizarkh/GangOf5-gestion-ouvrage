package com.Gangof5.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gangof5.ecommerce.model.Book;
import com.Gangof5.ecommerce.model.Stock;
import com.Gangof5.ecommerce.repository.StockRepository;
import com.Gangof5.ecommerce.repository.BookRepository;
@Service
public class StockService implements IStockService{

	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
    public List<Stock> getStocks (int b) {
		Book book = bookRepository.findById(b).get();
        return  (List<Stock>)stockRepository.findByBook(book);
        
    }
	 @Override
	    public Stock createStock (Stock s) {
		 
	        return  stockRepository.save(s);
	    }
	 @Override
	    public Stock updateStock(Stock s) {
	        return  stockRepository.save(s);
	    }
	 @Override
	    public void deleteStock(int id) {
		 stockRepository.deleteById(id);
	    }
}
