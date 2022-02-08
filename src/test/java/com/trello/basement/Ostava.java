package com.trello.basement;

import com.trello.api.rest.model.response.ColumnListResponse;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import support.ApplicationUrlUtils;

import java.util.Collections;
import java.util.List;

public class Ostava {

    @Test
    public void createBoard() {



//        QueryParams queryParams = new QueryParams();
//        RestAssured.baseURI = ReadPropertyFile.getBaseUrl();
//
//        queryParams
//                .createBoardParams(ReadPropertyFile.getCreateBoardAPI())
//                .then()
//                .statusCode(SC_OK);

//        Response response = QueryParams
//                .createBoardParams(ReadPropertyFile.getCreateBoardAPI());
//        assertEquals(response.getStatusCode(), STATUS_CODE_OK);
    }


//    public BoardResponse getBoard() {
//        RestAssured.baseURI = getBaseUrl();
//        RequestSpecification request = RestAssured.given();
//
//        Response response = request
//                .header("Accept", "application/json")
//                .queryParam("key", getKey())
//                .queryParam("token", getToken())
//                .pathParam("id", "611ec94354bb5a1f9a552137")
//                .body("")
//                .get("/1/boards/{id}");
//
//        ResponseBody responseBody = response.getBody();
//        BoardResponse board = responseBody.as(BoardResponse.class);
//
//        return board;
//
//    }



    public List<ColumnListResponse> getColumnList() {
        RestAssured.baseURI = ApplicationUrlUtils.getBaseUrlApi();
        RequestSpecification request = RestAssured.given();

        Response response = request
                .header("Accept", "application/json")
                .queryParam("key", ApplicationUrlUtils.getKey())
                .queryParam("token", ApplicationUrlUtils.getToken())
                .pathParam("id", "611ec94354bb5a1f9a552137")
                .body("")
                .get("/1/boards/{id}/lists");

        ResponseBody responseBody = response.getBody();
        List<ColumnListResponse> columnListResponses = responseBody.as(new TypeRef<List<ColumnListResponse>>() {
        });
        return columnListResponses;

    }

    @Test
    public void test2() {

        List<ColumnListResponse> aaa = getColumnList();

        Collections.sort(aaa);

        for (ColumnListResponse test : aaa) {
            System.out.println(test.getName());
        }
    }

    //    public void sendResult(String testId, ITestResult result) throws IOException, TestRailAPIException {
//        TestResultRequest request = new TestResultRequest();
//        int automationUserId = applicationUrlUtils.getAutomationUserId();
//        request.setAssignedto_id(automationUserId);
//        if (result.getStatus() == ITestResult.SUCCESS) {
//            request.setStatus_id(1);
//        } else {
//            request.setStatus_id(5);
//        }
//
//        String testRailEmail = applicationUrlUtils.getTestRailEmail();
//        String testRailPassword = applicationUrlUtils.getTestRailPassword();
//        String baseApiUrl = applicationUrlUtils.getTestRailBaseApiUrl();
//
//        TestRailAPIClient client = new TestRailAPIClient(baseApiUrl);
//        client.setUser(testRailEmail);
//        client.setPassword(testRailPassword);
//
//        JSONObject postResult = (JSONObject) client.sendPost("add_result/" + testId, request);
//    }

//    public void sendResult(String testId, ITestResult result) {
//        TestResultRequest request = new TestResultRequest();
//        int automationUserId = applicationUrlUtils.getAutomationUserId();
//        request.setAssignedto_id(automationUserId);
//        if (result.getStatus() == ITestResult.SUCCESS) {
//            request.setStatus_id(1);
//        } else {
//            request.setStatus_id(5);
//        }
//
//        String testRailEmail = applicationUrlUtils.getTestRailEmail();
//        String testRailPassword = applicationUrlUtils.getTestRailPassword();
//
//        JSONObject postResult = WebClient.builder()
//                .defaultHeaders(httpHeaders -> httpHeaders.setBasicAuth(testRailEmail, testRailPassword))
//                .build()
//                .post()
//                .uri("https://mitraxtest.testrail.io/index.php?/api/v2/add_result/1")
//                .body(Mono.just(request), TestResultRequest.class)
//                .retrieve()
//                .bodyToMono(JSONObject.class)
//                .block();
//    }

}
