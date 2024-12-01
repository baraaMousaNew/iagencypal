package rest_assured;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.harrel.jsonschema.Validator;
import dev.harrel.jsonschema.ValidatorFactory;
import dev.harrel.jsonschema.providers.JacksonNode;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class ResponseHelper {

    @Step("Assert response code in response")
    public void assertResponseCode(Response response, int expectedResCode){
        SoftAssertions softAssertions = softAssertValue(response.getStatusCode(), expectedResCode);
        if(!softAssertions.errorsCollected().isEmpty()){
            Assert.fail("Expected: " + expectedResCode + " but found: " +
                    response.getStatusCode() + " as:\n" + response.getStatusLine());
        }
        softAssertions.assertAll();
    }

    @Step("Assert body equals body example in file")
    public void assertResponseBodyAsString(Response response, String examplePath){
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node;
        try {
            node = objectMapper.readTree(new File(examplePath));
        }catch (IOException e){
            throw new RuntimeException("Couldn't open the file: " + examplePath);
        }
        Assert.assertEquals(response.body().asString(), node.toString());
    }

    @Step("Assert response body equals example in file using JsonNode")
    public void assertResponseBodyJsonNode(Response response, String examplePath){
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode exampleNode;
        JsonNode responseNode;
        try {
            exampleNode = objectMapper.readTree(new File(examplePath));
            responseNode = objectMapper.readTree(response.body().asString());
        }catch (IOException e){
            throw new RuntimeException("Error loading JsonNode, see:\n" + e.toString());
        }
        Assert.assertEquals(responseNode, exampleNode);
    }

    @Step("Assert response with schema")
    public void assertResponseSchemaIncluded(Response response, String schemaPath, String examplePath){
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode node;
        try {
            node = objectMapper.readTree(new File(schemaPath));
        }catch (IOException e){
            throw new RuntimeException("Couldn't open the file: " + schemaPath);
        }
        Validator validator = new ValidatorFactory().
                withJsonNodeFactory(new JacksonNode.Factory()).createValidator();
        URI schemaUri = validator.registerSchema(node);
        Validator.Result result = validator.validate(schemaUri, response.body().asString());
        Assert.assertTrue(result.isValid());
        assertResponseBodyJsonNode(response, examplePath);
    }


    public <T> void assertValue(T actual, T expected){
        Assert.assertEquals(actual, expected);
    }


    public <T> void assertNotValue(T actual, T expected){
        Assert.assertNotEquals(actual, expected);
    }

    public <T> SoftAssertions softAssertValue(T actual, T expected){
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actual).isEqualTo(expected);
        return softAssertions;
    }

    public <T> SoftAssertions softAssertNotValue(T actual, T expected) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actual).isNotEqualTo(expected);
        return softAssertions;
    }
}
