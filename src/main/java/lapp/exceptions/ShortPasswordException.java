package lapp.exceptions;

public class ShortPasswordException extends Exception{
    public ShortPasswordException() {
        super("The password must have more than 8 characters");
    }
}
