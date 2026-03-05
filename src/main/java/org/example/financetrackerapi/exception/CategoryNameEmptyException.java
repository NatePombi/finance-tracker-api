package org.example.financetrackerapi.exception;

public class CategoryNameEmptyException extends RuntimeException {
    public CategoryNameEmptyException(String message) {
        super(message);
    }
}
