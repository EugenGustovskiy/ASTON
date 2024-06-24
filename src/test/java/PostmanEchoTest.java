import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void getRequestTest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("get")
                .then()
                .log().body()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void postRawTextTest() {
        given()
                .contentType("application/json")
                .body("{\"test\":\"value\"}")
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(200)
                .body("json.test", equalTo("value"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void postFormDataTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")

                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().body()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void putRequestTest() {
        given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void patchRequestTest() {
        given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void deleteRequestTest() {
        given()
                .contentType("application/json")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}