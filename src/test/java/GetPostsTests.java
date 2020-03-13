import org.testng.annotations.*;
import utils.ApiUtils;

public class GetPostsTests extends BaseTest {
    @Test
    public void T01_StatusCodeTest() {
        res = ApiUtils.getResponse(); //Get response
        jp = ApiUtils.getJsonPath(res); //Get JsonPath
        testUtils.checkStatusIs200(res);
    }

    @Test
    public void T02_GetPosts() {
        res = ApiUtils.getResponse();
        jp = ApiUtils.getJsonPath(res);
        System.out.println(testUtils.getClients(jp));
    }
}
