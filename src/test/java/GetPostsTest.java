import org.testng.annotations.*;
import utils.ApiUtils;

public class GetPostsTest extends BaseTest {
    @Test
    public void T01_CheckStatusCode() {
        res = ApiUtils.getResponse();
        jp = ApiUtils.getJsonPath(res);
        testUtils.checkStatusIs200(res);
    }

    @Test
    public void T02_CheckContentType() {
        res = ApiUtils.getResponse();
        jp = ApiUtils.getJsonPath(res);
        testUtils.checkContentTypeIsJson(res);
    }

    @Test
    public void T03_GetPosts() {
        res = ApiUtils.getResponse();
        jp = ApiUtils.getJsonPath(res);
        System.out.println(testUtils.getPosts(jp));
    }

    @Test
    public void T04_CheckSchemaValidity()
    {
        res = ApiUtils.getResponse();
        testUtils.checkSchemaValidity(res, "list_post_schema.json");
    }
}
