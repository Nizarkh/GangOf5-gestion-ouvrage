package com.Gangof5.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Gangof5.ecommerce.model.Book;
import com.Gangof5.ecommerce.model.Stock;
@Repository
public interface StockRepository extends CrudRepository<Stock, Integer>{

	List<Stock> findByBook(Book book);
}
