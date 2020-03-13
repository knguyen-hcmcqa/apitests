package Utils;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestUtils {

    public void checkStatusIs200(Response res) {
        Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed!");
    }

    public void checkContentTypeIsJson(Response res) {
        Assert.assertEquals(res.getContentType(), "application/json; charset=utf-8", "Check Content-Type Failed!");
    }

    public ArrayList getPosts(JsonPath jp) {
        ArrayList clientList = jp.get();
        return clientList;
    }

    public void checkPostId(JsonPath jp, int id) {
        Assert.assertEquals(Integer.toString((id)), jp.get("id").toString(), "Check Post Id Failed!");
    }

    public void checkPostTitle(JsonPath jp, String title) {
        Assert.assertEquals(title, jp.get("title").toString(), "Check Post Title Failed!");
    }

    public void checkStatusIs404(Response res) {
        Assert.assertEquals(res.getStatusCode(), 404, "Status Check Failed!");
    }

    public void checkSchemaValidity(Response res, String schema) {
        res.then().assertThat().body(matchesJsonSchemaInClasspath(schema));
    }

}