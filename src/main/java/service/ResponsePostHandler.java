package service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

@SuppressWarnings("Duplicates")
public class ResponsePostHandler {

  public void testEndpoint() throws UnirestException {

    HttpResponse<JsonNode> jsonResponse = Unirest.post("http://httpbin.org/post")
        .header("accept", "application/json")
        .queryString("apiKey", "123")
        .field("parameter", "value")
        .field("foo", "bar")
        .asJson();

    String getUrl = "app.apple.com";
    GetRequest getRequest = Unirest.get(getUrl);
    getRequest.getBody();

    String postUrl = "app.apple.com";
    HttpRequestWithBody postRequest = Unirest.post(postUrl);

  }

}
