package com.example.rxjavaandretrofit.models;

import androidx.annotation.IntDef;
import androidx.annotation.Nullable;

public class Action<TRes> {


    public static final int ACTION_SUCCESS = 0;
    public static final int ACTION_FAILURE = 1;


    @IntDef({ACTION_SUCCESS, ACTION_FAILURE})
    @interface Status {
    }

    @Status
    private int mStatus;
    private String mMessage;
    private Throwable mError;
    private TRes mResponseResult;


    private Action(@Status int status, String message, Throwable error, @Nullable TRes result) {
        this.mStatus = status;
        this.mMessage = message;
        this.mError = error;
        this.mResponseResult = result;
    }

    public static <TRes> Action responseSuccess(String message, TRes result) {
        return new Action(ACTION_SUCCESS, message, null, result);
    }

    public static Action responseFailure(Throwable e) {
        return new Action(ACTION_FAILURE, null, e, null);
    }

    public int getStatus() {
        return mStatus;
    }

    public String getMessage() {
        return mMessage;
    }

    public Throwable getError() {
        return mError;
    }

    public TRes getResult() {
        return mResponseResult;
    }

}