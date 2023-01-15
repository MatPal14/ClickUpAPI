package pl.akademia.tests.space;

import io.restassured.response.Response;
import org.json.JSONObject;
import pl.akademia.URL.ClickUpURL;
import pl.akademia.properties.ClickupProperties;
import pl.akademia.requests.space.BaseRequest;

import static io.restassured.RestAssured.given;

public class CreateSpaceRequest {

    public static Response createSpace(JSONObject space) {

        return given()
                .spec(BaseRequest.requestSpecWithLogs())
                .body(space.toString())
                .when()
                .post(ClickUpURL.getSpacesUrl(ClickupProperties.getTeamId()))
                .then()
                .log().ifError()
                .extract()
                .response();


    }
}
