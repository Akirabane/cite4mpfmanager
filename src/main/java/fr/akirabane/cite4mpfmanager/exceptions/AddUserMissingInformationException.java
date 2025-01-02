package fr.akirabane.cite4mpfmanager.exceptions;

public class AddUserMissingInformationException extends RuntimeException {
    public AddUserMissingInformationException(String errorMessage) {
        super(errorMessage);
    }
}
