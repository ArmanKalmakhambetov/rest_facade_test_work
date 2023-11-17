package com.example.restfacadeapi.controller;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class StudentRestControllerTest {

    private static final String BASE_URL = "http://localhost:5050/api/students";

    @Test
    public void getAllStudents_shouldReturn200() {
        get(BASE_URL)
                .then()
                .statusCode(200);
    }

    @Test
    public void getStudentsByCourseId_shouldReturnStudents() {
        Long courseId = 2L;
        given()
                .pathParam("courseId", courseId)
                .when()
                .get(BASE_URL + "/course/{courseId}")
                .then()
                .statusCode(200)
                .body("size()", equalTo(2))
                .body("[0].id", equalTo(1))
                .body("[1].id", equalTo(3));
    }

    @Test
    public void getStudentById_shouldReturn200() {
        Long studentId = 2L;
        given()
                .pathParam("id", studentId)
                .when()
                .get(BASE_URL + "/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(studentId.intValue()));
    }

    @Test
    public void saveStudent_shouldReturn200() {
        String requestBody = """
                {
                    "firstName": "Arman",
                    "lastName": "Kalmakhambetov",
                    "email": "ara@mail.ru",
                    "coursesDTO": [
                        {
                            "nameOfCourse": "Math2"
                        },
                        {
                            "nameOfCourse": "Mathematics"
                        },
                        {
                            "nameOfCourse": "Physics"
                        }
                    ]
                }
                """;
        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post(BASE_URL)
                .then()
                .statusCode(200)
                .body("firstName", equalTo("Arman"));
    }

    @Test
    public void deleteStudent_shouldReturn200() {
        Long studentId = 3L;
        given()
                .pathParam("id", studentId)
                .when()
                .delete(BASE_URL + "/{id}")
                .then()
                .statusCode(200)
                .body(equalTo("Student with id = " + studentId + " was deleted"));
    }
}
