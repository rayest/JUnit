package cn.rayest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Rayest on 2016/10/5 0005.
 */


@RestController
@RequestMapping("/")
public class ComparisonController {

    @Resource
    private ComparisonServiceImpl testProjectServiceImpl;

    @RequestMapping(value = "/number/minus", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String NumberMinus(@RequestParam("longString") String longString, @RequestParam("shortString") String shortString) {
        int result = testProjectServiceImpl.compare(longString, shortString);
        if (result >= 10) {
            return "big difference";
        } else {
            return "small difference";
        }
    }
}
