package com.aou.Full_stack_validation.exceptions;

public class userNotFoundException extends RuntimeException{
    public userNotFoundException (Long id){
        super("Böyle bir id li user bulunmadı"+id);

    }
}
