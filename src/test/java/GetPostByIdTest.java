import org.testng.annotations.*;
import utils.ApiUtils;

public class GetPostByIdTest extends BaseTest {
    @Test
    public void T01_CheckStatusCode() {
        res = ApiUtils.getResponsebyPath("/1");
        jp = ApiUtils.getJsonPath(res);
        testUtils.checkStatusIs200(res);
    }

    @Test
    public void T02_CheckContentType() {
        res = ApiUtils.getResponsebyPath("/1");
        jp = ApiUtils.getJsonPath(res);
        testUtils.checkContentTypeIsJson(res);
    }

    @Test
    public void T03_GetPostById() {
        res = ApiUtils.getResponsebyPath("/1");
        jp = ApiUtils.getJsonPath(res);

        testUtils.checkPostId(jp, 1);
        testUtils.checkPostTitle(jp, "Post 1");
    }

    @Test
    public void T04_GetPostByInvalidId() {
        res = ApiUtils.getResponsebyPath("/9999");
        jp = ApiUtils.getJsonPath(res);
        testUtils.checkStatusIs404(res);
    }

    @Test
    public void T05_CheckSchemaValidity()
    {
        res = ApiUtils.getResponsebyPath("/1");
        testUtils.checkSchemaValidity(res, "single_post_schema.json");
    }
}
