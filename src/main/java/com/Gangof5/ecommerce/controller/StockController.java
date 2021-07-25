package com.Gangof5.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Gangof5.ecommerce.service.StockService;
import com.Gangof5.ecommerce.model.Stock;


@RestController
@RequestMapping("/api/testStock")
public class StockController {

	@Autowired
	StockService stockService ;
	
	@GetMapping("/getStocks/{id}")
	    @ResponseBody
	    public List<Stock> getStocks (@PathVariable("id") int id){
	    	return stockService.getStocks(id);
	    }

    @PostMapping("/createStock")
    @ResponseBody
    public void createStock (@RequestBody Stock s){
    	stockService.createStock(s);
    }

    @PutMapping("/updateStock")
    @ResponseBody
    public void updateStock (@RequestBody Stock s){
    	stockService.updateStock(s);
    }

    @DeleteMapping("/deleteStock/{id}")
    @ResponseBody
    public void  deleteStock (@PathVariable("id")int id){
    	stockService.deleteStock(id);
    }

}
