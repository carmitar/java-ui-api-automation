package testrail;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.springframework.web.reactive.function.client.WebClient;
import org.testng.ITestResult;
import reactor.core.publisher.Mono;
import support.ApplicationUrlUtils;
import testrail.request.TestResultRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.apache.http.HttpStatus.SC_OK;
import static support.ApplicationUrlUtils.getBaseUrlApi;
import static support.ApplicationUrlUtils.getTestRailBaseApiUrl;

public class TestRailService {

    private final ApplicationUrlUtils applicationUrlUtils;

    public TestRailService() {
        applicationUrlUtils = new ApplicationUrlUtils();
    }



    public void sendResult(String testId, ITestResult result) {
        TestResultRequest request = new TestResultRequest();
        request.setAssignedto_id(applicationUrlUtils.getAutomationUserId());

        if (result.getStatus() == ITestResult.SUCCESS) {
            request.setStatus_id(1);
        } else {
            request.setStatus_id(5);
        }

        String testRailEmail = applicationUrlUtils.getTestRailEmail();
        String testRailPassword = applicationUrlUtils.getTestRailPassword();
        System.out.println("AAAAAAAA "+getTestRailBaseApiUrl()+"/index.php?/api/v2/add_result/" + testId +"");

        RestAssured.given()
                .auth()
                .preemptive()
                .basic(testRailEmail, testRailPassword)
                .baseUri(getTestRailBaseApiUrl())
                .contentType(ContentType.JSON)
                .body(request)
                .post("/index.php?/api/v2/add_result/" + testId +"")
                .then()
                .statusCode(200);
    }
}
