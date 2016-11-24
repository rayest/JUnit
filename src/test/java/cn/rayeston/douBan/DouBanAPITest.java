package cn.rayeston.douBan;

import cn.rayeston.foundation.annotation.Scenario;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

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
        get("https://api.douban.com/v2/book/1220562")
                .then()
                .body("title", equalTo("满月之夜白鲸现"));
    }

    @Scenario("URL为 https://api.douban.com/v2/book/search?q=java8, 判断 Json 中的返回信息关键字为 “ java8 ” 的书本的数目")
    @Test
    public void testCountJava8Books() throws Exception {
        given()
                .param("q", "java8")
                .when()
                .get("https://api.douban.com/v2/book/search")
                .then()
                .body("count", equalTo(2));
    }

    @Scenario("解析 https://api.douban.com/v2/book/1220562 请求的 JSON 数据")
    @Test
    public void testParseJSON() throws Exception {
        ValidatableResponse validatableResponse = get("https://api.douban.com/v2/book/1220562").then();
        validatableResponse.body("title", equalTo("满月之夜白鲸现"));
        validatableResponse.body("rating.max", equalTo(10)); //判断二级属性rating.max的值
        validatableResponse.body("tags.size()", is(8)); //调用数组的方法判断数组的大小
        validatableResponse.body("tags[0].name", equalTo("片山恭一")); //判断数组第一个对象的值
        validatableResponse.body("author", hasItems("[日] 片山恭一")); //判断数组中是否有该元素
    }

    @Scenario("解析 https://api.douban.com/v2/book/1220562 请求的 JSON 数据, 也可以按如下格式进行")
    @Test
    public void testParseJSONAnother() throws Exception {
        get("https://api.douban.com/v2/book/1220562")
                .then()
                .body("title", equalTo("满月之夜白鲸现"))
                .body("rating.max", equalTo(10)) //判断二级属性rating.max的值
                .body("tags.size()", is(8)) //调用数组的方法判断数组的大小
                .body("tags[0].name", equalTo("片山恭一")) //判断数组第一个对象的值
                .body("author", hasItems("[日] 片山恭一")); //判断数组中是否有该元素
    }

    @Scenario("如果返回的数据是 json 格式，可以通过 jsonSchema 验证返回结果")
    @Test
    public void testDouBanAPIByJsonSchema() throws Exception {
        given()
                .headers("Accept", "application/JSON")
                .when()
                .get("https://api.douban.com/v2/book/1220562")
                .then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("douban.json"));
    }

    @After
    public void tearDown() throws Exception {
    }
}
