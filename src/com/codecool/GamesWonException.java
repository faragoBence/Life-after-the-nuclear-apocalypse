package com.codecool;
public class GamesWonException extends Exception {
    String message;
    
    public GamesWonException(String message) {
        super(message);
        this.message = message;
}
    public String getMessage(){
        return message;
    }
}