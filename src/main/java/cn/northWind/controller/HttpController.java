package cn.northWind.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rayest on 2016/10/5 0005.
 */
@RestController
public class HttpController {

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getBook(){
        return "1984";
    }

    @RequestMapping(value = "/music", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getMusic(){
        return "music";
    }

}
