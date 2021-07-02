package com.Gangof5.ecommerce.controller;

import com.Gangof5.ecommerce.common.ApiResponse;
import com.Gangof5.ecommerce.dto.book.BookDto;
import com.Gangof5.ecommerce.model.Book;
import com.Gangof5.ecommerce.model.Category;
import com.Gangof5.ecommerce.service.CategoryService;
import com.Gangof5.ecommerce.utils.UploadBookResponse;
import com.Gangof5.ecommerce.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Book")
public class BookController {
	
    @Autowired BookService bookService;
    
    //localhost:8080/Book/uploadFile/
    @PostMapping("/uploadFile/")
	public UploadBookResponse uploadBook(@RequestParam("file") MultipartFile file) {

		Book book = bookService.storeBook(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(book.getId()).toUriString();
		return new UploadBookResponse(book.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
	}
	
	@PostMapping("/FormulaireToFile/{id}")
	public int FormulaireToFile(@PathVariable("id") String id,@RequestBody Book book) {

		bookService.AffecterFileFormulaire(id, book);
		bookService.deleteBook(id);
		
		return 99;
	}
	//localhost:8080/Book/getBook/76d5072c-a7d8-46ee-9f40-2e2db6fc7323
	@GetMapping("/getBook/{id}")
	public ResponseEntity<Resource> GetBook(@PathVariable("id") String id){
		Book book= bookService.getBook(id);
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(book.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + book.getFileName() + "\"")
                .body(new ByteArrayResource(book.getData()));
	}
	//localhost:8080/Book/getAllBooks
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks(){
		return  bookService.getAllBooks();
		
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public int deleteBook(@PathVariable("id") String id){
		bookService.deleteBook(id);
		return 990;
		
	}
	
	

	

}
