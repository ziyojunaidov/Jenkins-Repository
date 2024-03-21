package APITest;

import APITest.POJOClasses.Country;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CountryAPITest {
    Cookies cookies;
    RequestSpecification rs;
    @BeforeClass
    public void loginTest(){
        baseURI = "https://test.mersys.io/school-service/api/countries";

        Map<String, Object> credentials = new HashMap<>();
        credentials.put("username", "turkeyts");
        credentials.put("password", "TechnoStudy123");
        credentials.put("rememberMe", true);

          cookies = given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post("https://test.mersys.io/auth/login")
                .then()
                .log().body()
                .statusCode(200)
                .extract().response().getDetailedCookies(); // Extract the access token as a cookie
        // so we can use it in other test as authorization

//        rs = new RequestSpecBuilder()
//                .setContentType(ContentType.JSON)
//                .addCookies(cookies)
//                .build();
    }
    @Test(priority = 2)
    public void getListOfCountries(){


        given()
                .body("{}")
                .contentType(ContentType.JSON)
                .cookies(cookies)
                .when()
                .post("https://test.mersys.io/school-service/api/countries/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name",hasItem(responseCountry.getName()));
    }
    public String randomCountry(){
        return RandomStringUtils.randomAlphabetic(8);
    }
    public String randomCountryCode(){
        return RandomStringUtils.randomAlphanumeric(8);
    }
    Country requestCountry;
    Country responseCountry;
    @Test(priority = 1)
    public void createCountry(){
         requestCountry = new Country();
        requestCountry.setId(null);
        requestCountry.setName(randomCountry());
        requestCountry.setCode(randomCountryCode());
        requestCountry.setTranslateName(new ArrayList<>());
        requestCountry.setHasState(false);

          responseCountry = given()
                .body(requestCountry)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .log().body()
                 .extract().jsonPath().getObject("", Country.class);

        Assert.assertEquals(requestCountry.getName(),responseCountry.getName());
        Assert.assertEquals(requestCountry.getCode(),responseCountry.getCode());
    }
    @Test(dependsOnMethods = "createCountry", priority = 3)
    public void createCountryNegativeTest(){
//        Country country = new Country();
//        country.setId(null);
//        country.setName(responseCountry.getName());
//        country.setCode(responseCountry.getCode());
//        country.setTranslateName(new ArrayList<>());
//        country.setHasState(false);
        given()
                .body(requestCountry)
//                .body(country)
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(400);
    }
    @Test(dependsOnMethods = "createCountry", priority = 4)
    public void getCountryByName(){
        given()
                .body("{\"name\":\""+responseCountry.getName()+"\"}")
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .when()
                .post("/search")
                .then()
                .statusCode(200);
    }
    @Test(dependsOnMethods = "createCountry", priority = 5)
    public void updateCountry(){
//        responseCountry.setName(randomCountry());
//        responseCountry.setCode(randomCountryCode());

        requestCountry.setId(responseCountry.getId());
        requestCountry.setName(randomCountry());
        requestCountry.setCode(randomCountryCode());

        given()
//                .body(responseCountry)
                .body(requestCountry)
                .contentType(ContentType.JSON)
                .cookies(cookies)
                .when()
                .put()
                .then()
                .statusCode(200)
                .body("id",equalTo(requestCountry.getId()));
    }
    @Test(dependsOnMethods = "createCountry",priority = 6)
    public void deleteCountry(){
        given()
                .cookies(cookies)
                .pathParam("countryId",responseCountry.getId())
                .when()
//                .delete(""+responseCountry.getId())
                .delete("/{countryId}")
                .then()
                .statusCode(200);
    }
    @Test(dependsOnMethods = {"createCountry","deleteCountry"}, priority = 7)
    public void deleteCountryNegativeTest(){
        given()
                .cookies(cookies)
                .pathParam("countryId",responseCountry.getId())
                .when()
//                .delete(""+responseCountry.getId())
                .delete("/{countryId}")
                .then()
                .statusCode(400);
    }
}
