package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.vertx.core.json.Json;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class FunqyTest {

    @Test
    public void testDefaultChain() {
        RestAssured.given().contentType("application/json")
                .header("ce-id", UUID.randomUUID().toString())
                .header("ce-type", "defaultChain")
                .header("ce-source", "test")
                .body(getJSonData(getInput()))
                .post("/")
                .then().statusCode(200)
                .header("ce-id", notNullValue())
                .header("ce-type", "defaultChain.output")
                .header("ce-source", "defaultChain");
                System.out.println(getJSonData(getInput()));
    }

    @Test
    public void testConfigChain() {
        RestAssured.given().contentType("application/json")
                .header("ce-id", UUID.randomUUID().toString())
                .header("ce-type", "defaultChain.output")
                .header("ce-source", "test")
                .body(getJSonData(getInput()))
                .post("/")
                .then().statusCode(200)
                .header("ce-id", notNullValue())
                .header("ce-type", "annotated")
                .header("ce-source", "configChain");
    }

    @Test
    public void testAnnotatedChain() {
        RestAssured.given().contentType("application/json")
                .header("ce-id", UUID.randomUUID().toString())
                .header("ce-type", "annotated")
                .header("ce-source", "test")
                .body(getJSonData(getInput()))
                .post("/")
                .then().statusCode(200)
                .header("ce-id", notNullValue())
                .header("ce-type", "lastChainLink")
                .header("ce-source", "annotated");
    }



    private String getJSonData(Input input){
           
            return Json.encode(input);
    }

    private Input getInput(){
        return  new Input("Shaaf", "Denmark", "00100");
    }

    private Input getInputVerified(){
        Input input = new Input("Shaaf", "Denmark", "00100");
        input.setVerifiedDebts(true);
        input.setVerifiedDebts(true);
        input.setVerifiedPartners(true);
        input.setVerifiedPerson(true);
        
        return input;
    }
}
