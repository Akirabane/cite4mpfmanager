package fr.akirabane.cite4mpfmanager.exceptions;

public class UnitAlreadyExistException extends RuntimeException {
    public UnitAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
