package com.exception;

/**
 * @author Vikrant on 26-08-2023
 * @Project Quiz
 */
public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message){
        super(message);
    }
}
