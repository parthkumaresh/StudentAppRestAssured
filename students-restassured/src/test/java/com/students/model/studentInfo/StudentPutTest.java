package com.students.model.studentInfo;


import com.students.model.StudentPojo;
import com.students.model.testBase.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {

    //    Update Student Details
    @Test
    public void updateStudentDetails() {

        List<String> courses = new ArrayList<>();
        StudentPojo studentPojo = new StudentPojo();


        studentPojo.setFirstName("MissDani");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("mickey11@gmail.com");
        studentPojo.setProgramme("Children");
        studentPojo.setCourses(courses);
        courses.add("Aid");
        courses.add("Hygiene");

        // To Update the student detail
           given().header("content-Type", "application/json")
                   .when()
                   .body(studentPojo)
                   .put("106").then().statusCode(200);


    }
}
