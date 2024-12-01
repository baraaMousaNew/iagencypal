package rest_assured;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import driver_factory.DriverManager;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class PayLoadHelper {

    private JsonNode node;

    private RequestSpecification specs;

    private Response response;

    private Map<String, Object> allHeaders;

    private JSONObject bodyObject;

    @Step("Build the API file")
    public PayLoadHelper buildRequest(String apiJson){
        allHeaders = new HashMap<>();
        bodyObject = null;
        RestAssured.reset();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            node = objectMapper.readTree(new File(apiJson));
        }catch (IOException e){
            throw new RuntimeException("Couldn't open the file: " + apiJson);
        }
        specs = given();
        return this;
    }

    @Step("Get headers to call from the built API file")
    public PayLoadHelper getHeaders(){
        ArrayNode headers = (ArrayNode) node.get("log").get("entries").get(0).get("request").get("headers");
        for(JsonNode jsonNode: headers){
            if(!jsonNode.get("name").asText().equals("Content-Length")){
                allHeaders.put(jsonNode.get("name").asText(),jsonNode.get("value").asText());
            }
        }
        return this;
    }

    @Step("Get headers to call from the built API file with replacement")
    public PayLoadHelper replaceInHeaders(String name, String value){
        if(allHeaders.isEmpty()){
            ArrayNode headers = (ArrayNode) node.get("log").get("entries").get(0).get("request").get("headers");
            for(JsonNode jsonNode: headers){
                if(!jsonNode.get("name").asText().equals("Content-Length")
                        && !jsonNode.get("name").asText().equals(name) &&
                !jsonNode.get("name").asText().equals("User-Agent")){
                    allHeaders.put(jsonNode.get("name").asText(),jsonNode.get("value").asText());
                }
            }
        }
        allHeaders.put(name, value);
        return this;
    }

    @Step("Get URL to call from the built API")
    public PayLoadHelper getUrl(){
        specs.baseUri(node.get("log").get("entries").get(0).get("request").get("url").asText());
        return this;
    }

    @Step("Get request body to call from the built API")
    public PayLoadHelper getRequestBody(){
        bodyObject = new JSONObject(node.get("log").get("entries").get(0).get("request").get("postData").get("text").asText());
        return this;
    }

//    public PayLoadHelper getRequestBodyAndReplace(Map<String, Object> values){
//        String body = node.get("log").get("entries").get(0).get("request").get("postData").get("text").asText();
//        String [] keys = new String[values.size()];
//        int counter = 0;
//        for(String key: values.keySet()){
//            keys[0] = key;
//            counter++;
//        }
//        for(int i=0; i<values.size();i++){
//            String regex = "(?<=(\"" + keys[i] + "\":\"))([^\"])*";
//            BodyHelper.findInString(body, regex);
//            body = body.replaceAll(regex, (String)values.get(keys[i]));
//        }
//        specs.body(body);
//        return this;
//    }

    @Step("Get request body to call from the built API with replacement")
    public PayLoadHelper replaceInBody(String key, String value){
        if (Objects.isNull(bodyObject)) {
            bodyObject = new JSONObject(node.get("log").get("entries").get(0).get("request").get("postData").get("text").asText());
        }
        bodyObject.put(key, value);
        return this;
    }

    @Step("Add body to request from map")
    public PayLoadHelper addBodyMap(Map<String, String> bodyMap){
        specs.body(bodyMap);
        return this;
    }

    @Step("Send the API")
    public PayLoadHelper send(Method method){
        specs.headers(allHeaders);
        if(Objects.nonNull(bodyObject)){
            specs.body(bodyObject.toString());
            specs.contentType(ContentType.JSON);
        }
        response = specs.request(method);
        return this;
    }

    @Step("Add form data")
    public PayLoadHelper addFormData(Map<String, String> data){
//        specs.config(RestAssured.config().encoderConfig(
//                encoderConfig().encodeContentTypeAs("multipart/form-data",
//                        ContentType.TEXT)));
        for(String key : data.keySet()){
            specs.multiPart(key, Objects.toString(data.get(key),""));
        }
        return this;
    }

    @Step("Get body as string")
    public String getBody(){
        if(response == null){
            throw new RuntimeException("No response exists");
        }
        return response.body().asString();
    }

    @Step("Get response")
    public Response getResponse(){
        if(response == null){
            throw new RuntimeException("No response exists");
        }
        return response;
    }

    @Step("Get status code of the response")
    public int getStatusCode(){
        if(response == null){
            throw new RuntimeException("No response exists");
        }
        return response.statusCode();
    }

    @Step("Get headers from response")
    public Headers getResponseHeaders(){
        if(response == null){
            throw new RuntimeException("No response exists");
        }
        return response.getHeaders();
    }



}
