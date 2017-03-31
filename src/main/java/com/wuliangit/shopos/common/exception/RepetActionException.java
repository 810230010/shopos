package com.wuliangit.shopos.common.exception;

/**
 * Created by nilme on 2017/3/30.
 */
public class RepetActionException extends Exception implements ErrorInfoInterface {
    @Override
    public int getCode() {
        return 403;
    }

    public RepetActionException(String message){
        super(message);
    }
}
