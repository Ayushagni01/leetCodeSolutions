package com.examServer.ExamServer.helper;

public class UserFoundException extends  Exception{

    public UserFoundException(){
        super("User with user name is alreday in database Please choose Unique username ");
    }

    public UserFoundException(String msg)
    {
        super(msg);
    }




}
