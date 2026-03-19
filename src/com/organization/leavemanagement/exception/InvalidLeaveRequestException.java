package com.organization.leavemanagement.exception;

public class InvalidLeaveRequestException extends Exception{

    public InvalidLeaveRequestException(String message) {
        super(message);//super is used to call parent class constructor
    }

    public InvalidLeaveRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLeaveRequestException(Throwable cause) {
        super(cause);
    }

    public InvalidLeaveRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
