package com.students.model.studentInfo;


import com.students.model.testBase.TestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StudentGetTest extends TestBase {


    // Get All Student List
    @Test
    public void getAllStudentInformation() {


        /**
         * given()
         * set cookies,add auth,adding parameters,setting header info
         * .when()
         * GET,POST,PUT,DELETE..etc
         * .then()
         *  Validate status code,extract response, extract headers,cookies,extract the response body
         *
         */

          // Response response = given()
          // .when()
          // .get("/list");
          // response.then().statusCode(200);
          // System.out.println(response.body().prettyPrint());

//      In ValitableResponse  we always need to use .log.all into sout the list (we cant use preety print or body)
        ValidatableResponse validatableResponse = given()
                .when()
                .get("/list")
                .then().statusCode(200);
        System.out.println(validatableResponse.log().all());

        //Validate the status code


           //        given()
           //        .when()
           //        .get("/list")
           //        .then()
           //         .statusCode(200);

    }




    // Get All student Info By ID
    @Test
    public void getStudentInfo() {

        Response response = given()
                .when()
                .get("/1");

        System.out.println(response.body().prettyPrint());

        given()
                .when()
                .get("/1")
                .then()
                .statusCode(200);
    }




    //  Get Student From Programme
    @Test
    public void getStudentFromProgramme() {
        Response response2 = given()
                .param("programme", "Computer Science")
                .when()
                .get("/list");

        System.out.println(response2.prettyPeek());

    }




    //    Get Student By Programme with Limit
    @Test
    public void getStudentsFromByProgrammeWithLimit() {

     //       This is very basic way and this method will sow as learner try to not use this method
     //       Response response=	given()
     //       .when()
     //       .get("/list?programme=Financial Analysis&limit=2");
     //
     //       System.out.println(response.prettyPeek());

        Response response2 = given()
                .param("programme", "Computer Science")
                .param("limit", 5)
                .when()
                .get("/list");
        System.out.println(response2.prettyPeek());


    }
}

