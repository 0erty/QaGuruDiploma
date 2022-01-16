package com.quadcode.specification;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.quadcode.helpers.AllureRestAssuredFilter.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class ReqresSpec {
    public static RequestSpecification request = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);
}
