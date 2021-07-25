package com.Gangof5.ecommerce.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Gangof5.ecommerce.model.Book;



public interface IBookService {
	
public Book addBook(Book book);
public Book updateBook(Book book,int idBook);
public int deleteBook(int idBook);
public List<Book> getAllBooks();
public Book getBook(int idBook);

}
