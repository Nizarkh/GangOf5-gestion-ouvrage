package com.Gangof5.ecommerce.service;


import com.Gangof5.ecommerce.model.User;
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
	    @Autowired
		AuthenticationService authenticationService;
		@Override
		public Book addBook(Book book) {
			bookRepository.save(book);
			return book;
		}
		
		public static BookDto getDtoFromBook(Book book) {
			 BookDto bookDto = new BookDto(book);
		        return bookDto;
		    }
		@Override
		public Book updateBook(Book book, int idBook) {
		Book b=bookRepository.getById(idBook);
		b.setAuthor(book.getAuthor());
		b.setCopyright(book.getCopyright());
		b.setFileName(book.getFileName());
		b.setFileType(book.getFileType());
		b.setIsbn(book.getIsbn());
		b.setLanguages(book.getLanguages());
		b.setPage_count(book.getPage_count());
		b.setPrice(book.getPrice());
		b.setSubject(book.getSubject());
		bookRepository.save(b);
			return book;
		}
		@Override
		public int deleteBook(int idBook) {
			bookRepository.deleteById(idBook);
			return 9009;
		}
		@Override
		public List<Book> getAllBooks() {
			return bookRepository.findAll();
		}
		@Override
		public Book getBook(int bookId) {
			return bookRepository.findById(bookId).get();
		}

//		@Override
//		public Book getBook(String fileId) {
//			return bookRepository.getById(fileId);
//		}
//
//		@Override
//		public Book storeBook(MultipartFile file) {
//			String fileName=StringUtils.cleanPath(file.getOriginalFilename());
//			try {
//				if(fileName.contains("..")) {
//	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//	            }
//				Book book= new Book(fileName, file.getContentType(), file.getBytes());
//				return bookRepository.save(book);
//			} catch (Exception ex) {
//				throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//		}}
//
//		
//
//		@Override
//		public List<Book> getAllBooks() {
//			return bookRepository.findAll();
//		}
//
//		@Override
//		public int deleteBook(String fielId) {
//			bookRepository.deleteById(fielId);
//			return 99;
//		}
//		 public static BookDto getDtoFromBook(Book book) {
//			 BookDto bookDto = new BookDto(book);
//		        return bookDto;
//		    }
//
//		@Override
//		public int AffecterFileFormulaire(String id, Book book, String token) {
//			User user = authenticationService.getUser(token);
//			
//			
//			Book b=bookRepository.getById(id);
//			b.setAuthor(book.getAuthor());
//			b.setCopyright(book.getCopyright());
//			b.setIsbn(book.getIsbn());
//			b.setLanguages(book.getLanguages());
//			b.setPage_count(book.getPage_count());
//			b.setPrice(book.getPrice());
//			b.setSubject(book.getSubject());
//			b.setUserPrem(user);
//			bookRepository.save(b);
//		
////			book.setFileName(b.getFileName());
////			book.setFileType(b.getFileType());
////			book.setData(b.getData());
////			book.setUserPrem(user);
////			
////			bookRepository.save(book);		
//			
//			
//			return 99;
//		}
//
//		@Override
//		public Book getBookToEdit(String fileId, String token) {
//			User user = authenticationService.getUser(token);
//			Book b=bookRepository.getById(fileId);
//			Book b2=new Book();
//			b2.setAuthor(b.getAuthor());
//			b2.setCopyright(b.getCopyright());
//			b2.setIsbn(b.getIsbn());
//			b2.setLanguages(b.getLanguages());
//			b2.setPage_count(b.getPage_count());
//			b2.setPrice(b.getPrice());
//			b2.setSubject(b.getSubject());   
//			
//			
//			return b2;
//		}
//



}