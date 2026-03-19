package com.organization.leavemanagement.exception;

public class InsufficientLeaveBalanceException extends Exception{
    public InsufficientLeaveBalanceException(String message) {
        super(message);
    }

    public InsufficientLeaveBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientLeaveBalanceException(Throwable cause) {
        super(cause);
    }

    public InsufficientLeaveBalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
