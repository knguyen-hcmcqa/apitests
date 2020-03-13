import org.testng.annotations.*;
import utils.ApiUtils;

public class BasicApiTest extends BaseTest {

    @Test
    public void T01_StatusCodeTest() {
        res = ApiUtils.getResponse(); //Get response
        jp = ApiUtils.getJsonPath(res); //Get JsonPath
        testUtils.checkStatusIs200(res);
    }

//    @Test
//    public void T02_GetClients() {
//        res = ApiUtils.getResponsebyPath("/gen/clients");
//        jp = ApiUtils.getJsonPath(res);
//        System.out.println(testUtils.getClients(jp));
//    }
//
//    @Test
//    public void T03_GetAndroidModelPackageOptions() {
//        res = ApiUtils.getResponsebyPath("/gen/clients/android");
//        jp = ApiUtils.getJsonPath(res);
//        System.out.println("Opt: " + jp.get("modelPackage.opt"));
//        System.out.println("Description: " + jp.get("modelPackage.description"));
//        System.out.println("Type: " + jp.get("modelPackage.type"));
//    }

}