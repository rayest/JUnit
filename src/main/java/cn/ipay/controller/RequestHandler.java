package cn.ipay.controller;

/**
 * Created by Rayest on 2016/8/12 0012.
 */
public interface RequestHandler {
    Response process(Request request) throws Exception;
}
