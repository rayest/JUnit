package cn.ipay.controller;

/**
 * Created by Rayest on 2016/8/12 0012.
 */
public interface Controller {
    Response processRequest(Request request);
    void addHandler(Request request, RequestHandler requestHandler);
}
