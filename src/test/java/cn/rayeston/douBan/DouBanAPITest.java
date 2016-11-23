package cn.rayeston.douBan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by Rayest on 2016/11/23 0023.
 */
public class DouBanAPITest {
    @Before
    public void setUp() throws Exception {
        // RestAssured.baseURI = "http://api.douban.com/v2/book";
        // RestAssured.port = 80;
    }

    // URL为 https://api.douban.com/v2/book/1220562
    // 判断 Json 中的返回信息 title
    @Test
    public void TestGetBook() throws Exception {
        get("https://api.douban.com/v2/book/1220562").then().body("title", equalTo("满月之夜白鲸现"));
    }

    @After
    public void tearDown() throws Exception {
    }
}
