package com.students.model.studentInfo;


import com.students.model.testBase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentDeleteTest extends TestBase {

    @Test

    public void delStudentByID(){
        given()
                .when()
                .delete("/9")
                .then()
                .log().all()
                .statusCode(204);

    }

    @Test

    public void verifyDeltStudent(){

        given()
                .when()
                .get("/9")
                .then()
                .log().all()
                .statusCode(404);

    }

}