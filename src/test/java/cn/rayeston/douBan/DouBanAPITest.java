package cn.rayeston.douBan;

import cn.rayeston.foundation.annotation.Scenario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
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

    @Scenario("URL 为 https://api.douban.com/v2/book/1220562, 判断 Json 中的返回信息 “title” 是否为 “满月之夜白鲸现” ")
    @Test
    public void TestGetBook() throws Exception {
        get("https://api.douban.com/v2/book/1220562").then().body("title", equalTo("满月之夜白鲸现"));
    }


    @Scenario("URL为 https://api.douban.com/v2/book/search?q=java8, 判断 Json 中的返回信息关键字为 “ java8 ” 的书本的数目")
    @Test
    public void testGetJava8Books() throws Exception {
        given().param("q", "java8").when().get("https://api.douban.com/v2/book/search").then().body("count", equalTo(2));
    }


    @After
    public void tearDown() throws Exception {
    }
}
