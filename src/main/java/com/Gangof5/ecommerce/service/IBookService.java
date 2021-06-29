package com.Gangof5.ecommerce.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Gangof5.ecommerce.model.Book;



public interface IBookService {
	
	public Book getBook(String fileId);
	public Book storeBook(MultipartFile file);
	public int AffecterFileFormulaire(String id,Book book);
	public List<Book> getAllBooks();
	public int deleteBook(String fielId);

}
