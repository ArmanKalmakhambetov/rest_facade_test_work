package com.example.restfacadeapi.controller;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CourseRestControllerTest {

    private static final String BASE_URL = "http://localhost:5050/api/courses";

    @Test
    public void getAllCourses_shouldReturn200() {
        given()
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(200);
    }

    @Test
    public void getCourseById_shouldReturn200() {
        Long courseId = 2L;
        given()
                .pathParam("id", courseId)
                .when()
                .get(BASE_URL + "/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(courseId.intValue()));
    }


    @Test
    public void saveCourse_shouldReturn200() {
        String requestBody = "{\"nameOfCourse\": \"Mathematics 101\"}";
        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(200)
                .body("nameOfCourse", equalTo("Mathematics 101"));
    }


    @Test
    public void deleteCourse_shouldReturn200() {
        Long courseId = 1L;
        given()
                .pathParam("id", courseId)
                .when()
                .delete(BASE_URL + "/{id}")
                .then()
                .statusCode(200)
                .body(equalTo("Course with id = " + courseId + " was deleted"));
    }
}
