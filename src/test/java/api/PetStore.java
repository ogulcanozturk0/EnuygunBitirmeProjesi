package api;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class PetStore  {

    @Test
    public void petPost(){
        when().get("https://petstore.swagger.io/v2/pet").
                then().
                statusCode(200).
                body("data.name", (ResponseAwareMatcher<Response>) equalTo("cat"));

    }
}
