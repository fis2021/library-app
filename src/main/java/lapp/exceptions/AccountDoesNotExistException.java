package lapp.exceptions;

public class AccountDoesNotExistException extends Exception {

        public AccountDoesNotExistException() {
            super("This account does not exist!");
        }
    }