package pl.akademia.tests.space;

import io.restassured.response.Response;
import pl.akademia.URL.ClickUpURL;
import pl.akademia.requests.space.BaseRequest;

import static io.restassured.RestAssured.given;

public class DeleteSpaceRequest {

    public static Response deleteSpace(String spaceId) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .when()
                .delete(ClickUpURL.getSpaceUrl(spaceId))
                .then()
                .log().ifError()
                .extract()
                .response();


    }
}
