package com.Gangof5.ecommerce.service;

import com.Gangof5.ecommerce.exceptions.ProductNotExistException;
import com.Gangof5.ecommerce.model.Category;
import com.Gangof5.ecommerce.model.Book;
import com.Gangof5.ecommerce.repository.BookRepository;
import com.Gangof5.ecommerce.dto.book.BookDto;
import com.Gangof5.ecommerce.exceptions.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService{
    @Autowired
    private BookRepository bookRepository;

	@Override
	public Book getBook(String fileId) {
		return bookRepository.getById(fileId);
	}

	@Override
	public Book storeBook(MultipartFile file) {
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
			Book book= new Book(fileName, file.getContentType(), file.getBytes());
			return bookRepository.save(book);
		} catch (Exception ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	}}

	@Override
	public int AffecterFileFormulaire(String id, Book book) {
		Book b=bookRepository.getById(id);
		book.setFileName(b.getFileName());
		book.setFileType(b.getFileType());
		book.setData(b.getData());
		
		bookRepository.save(book);
		
		return 99;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public int deleteBook(String fielId) {
		bookRepository.deleteById(fielId);
		return 99;
	}
	 public static BookDto getDtoFromBook(Book book) {
		 BookDto bookDto = new BookDto(book);
	        return bookDto;
	    }




}