package com.students.model.studentInfo;


import com.students.model.StudentPojo;
import com.students.model.testBase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentPatchTest extends TestBase {



// Update Email ID
    @Test
    public void editStudentDetailsWithEmail() {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setEmail("newbcc@gmail.com");
        given().header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .patch("/100").then().statusCode(200);
    }


}
