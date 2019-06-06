package com.students.model.studentInfo;

import com.students.model.StudentPojo;
import com.students.model.testBase.TestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentsPostTest extends TestBase {
    // Create New Student
    @Test
    public void createNewStudent() {
        List<String> courses = new ArrayList<>();
        courses.add("FirstAid");
        courses.add("FoodHygiene");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Parth");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("mickey9999@gmail.com");
        studentPojo.setProgramme("Childcare");
        studentPojo.setCourses(courses);

        given().header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post().then().log().all().statusCode(201);
    }

    // verify that new student has added
    @Test
    public void verifyingStudentCreated() {

        // This is assert method
        String p1 = "findAll{it.firstName=='";
        String p2 = "'}.get(0)";
        HashMap<String, Object> value = given()
                .when()
                .get("/list")
                .then().log().all()
                .statusCode(200)
                .extract()
                .path(p1 + "Dani" + p2);
        System.out.println("The value is: " + value);
    }

    // First Name With Null Pointer
    @Test
    public void createFirstNameWithNull() {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("mickey999999@gmail.com");
        studentPojo.setProgramme("Childcare");

       // String expectedText = "{\"error\":\"Please correct the following errors\",\"fieldErrors\":{\"firstName\":\"may not be empty\"}}";

        given().header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post()
                .then()
                .statusCode(500);
    }

    // Verify  First Name
    // Last Name With Null Pointer
    @Test
    public void createLastNameWithNull() {
        StudentPojo studentPojo = new StudentPojo();
        List<String> courses = new ArrayList<>();
        courses.add("Singing");
        courses.add("Dancing");
        courses.add("Drama");

        studentPojo.setFirstName("Minakumari");
        studentPojo.setLastName("");
        studentPojo.setEmail("minakumari@gmail.com");
        studentPojo.setProgramme("Bollywood Actress");
        studentPojo.setCourses(courses);

        //String expectedText = "{\"msg\":\"Student added\"}";

        given().header("Content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post()
                .then().statusCode(201);
                /*.and()
                .body(equalTo(expectedText));*/
    }
    // Verify Last Name

        // Email Null Pointer
    @Test
    public void createEmailWithNull() {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Parth");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("");
        studentPojo.setProgramme("Childcare");

        given().header("content-Type", "application/json")
                .when()
                .body(studentPojo)
                .post().then().log().all().statusCode(500);
    }

    // Verify Email
    @Test
    public void verifyStudentEmailIsNUll() {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("email");

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: firstName (Note: You should not put $. in the Java code)
        String firstName = jsonPathEvaluator.get("email");

        // Validate the response
        Assert.assertEquals(firstName, "Student added", "Student added");
    }




}
