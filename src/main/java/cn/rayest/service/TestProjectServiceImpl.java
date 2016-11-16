package cn.rayest.service;

import org.springframework.stereotype.Service;

/**
 * Created by Rayest on 2016/10/5 0005.
 */
@Service
public class TestProjectServiceImpl implements TestProjectService {

    public int compare(String longString, String shortString) {

        return longString.length() - shortString.length();
    }
}
