package com.Gangof5.ecommerce.exceptions;

public class FileStorageException extends RuntimeException{

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
