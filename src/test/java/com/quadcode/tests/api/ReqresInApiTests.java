package com.quadcode.tests.api;

import com.quadcode.model.LombokUserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.quadcode.specification.ReqresSpec.request;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Reqres")
class ReqresInApiTests {

    @Test
    @DisplayName("Successful single user (API)")
    void getListUser() {
        LombokUserData data = given()
                .spec(request)
         .when()
                .get("/users/2")
         .then()
                .statusCode(200)
                .log().body()
                .extract().as(LombokUserData.class);

        assertEquals("Janet", data.getUser().getFirstName());
    }

    @Test
    @DisplayName("Successful user creating (API)")
    void postCreateUser() {
        given()
                .spec(request)
                .body("{ \"name\": \"morpheus\", \"job\": \"leader\" }")
        .when()
                .post("/users")
        .then()
                .statusCode(201)
                .body("name", is("morpheus"));
    }

    @Test
    @DisplayName("Successful user updating (API)")
    void putUpdateUser() {
        given()
                .spec(request)
                .body("{ \"name\": \"morpheus\", \"job\": \"zion resident\" }")
        .when()
                .put("/users/2")
        .then()
                .statusCode(200)
                .body("job", is("zion resident"));
    }

    @Test
    @DisplayName("Successful user updating (2 method) (API)")
    void patchUpdateUser() {
        given()
                .spec(request)
                .body("{ \"name\": \"morpheus\", \"job\": \"zion resident\" }")
        .when()
                .patch("/users/2")
         .then()
                .statusCode(200)
                .body("job", is("zion resident"));
    }

    @Test
    @DisplayName("Successful user deleting (API)")
    void deleteUser() {
        given()
                .spec(request)
        .when()
                .delete("https://reqres.in/api/users/2")
        .then()
                .statusCode(204);
    }
}
