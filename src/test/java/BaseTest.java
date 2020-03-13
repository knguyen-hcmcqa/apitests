import Utils.TestUtils;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ApiUtils;

public class BaseTest {

    public Response res = null; //Response
    public JsonPath jp = null; //JsonPath

    TestUtils testUtils = new TestUtils();

    @BeforeClass
    public void setup() {
        //Test Setup
        ApiUtils.setBaseURI(); //Setup Base URI
        ApiUtils.setBasePath("posts"); //Setup Base Path
        ApiUtils.setContentType(ContentType.JSON); //Setup Content Type
    }

    @AfterClass
    public void afterTest() {
        ApiUtils.resetBaseURI();
        ApiUtils.resetBasePath();
    }

}