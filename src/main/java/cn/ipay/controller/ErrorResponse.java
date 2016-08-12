package cn.ipay.controller;

/**
 * Created by Rayest on 2016/8/12 0012.
 */
public class ErrorResponse implements Response {

    private static final String NAME = "Error";
    private Request originRequest;
    private Exception originException;

    public ErrorResponse(Request request, Exception exception) {
    }

    public Request getOriginRequest() {
        return originRequest;
    }

    public String getName() {
        return NAME;
    }

    public void setOriginRequest(Request originRequest) {
        this.originRequest = originRequest;
    }

    public Exception getOriginException() {
        return originException;
    }

    public void setOriginException(Exception originException) {
        this.originException = originException;
    }


}
