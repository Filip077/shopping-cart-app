package com.project.shoppingcartapp.exception;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String message){
        super(message);
    }
    public NoDataFoundException(){

    }
}
