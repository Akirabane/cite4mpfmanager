package fr.akirabane.cite4mpfmanager.exceptions;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}