package de.heallife.app.data.service.library.Post;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Post {


    private final RestTemplate restTemplate;
    private final String apiHost = "https://heallife.de/wp-json/";


    public Post(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPostsPlainJSON() {
        String url = "/jwt-auth/v1/token";
        return this.restTemplate.getForObject(url, String.class);
    }

    public String sendAuthRequest() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setBasicAuth("appuser_spring_auth_user_4694156", "SpBKoRfAc#7oFpcKg$zghPh7$BDeF3kxAiEH7SGG");

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                apiHost,
                HttpMethod.GET,
                request,
                String.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            return "Request Successful.";
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
        }
        return response.getBody() + response.getStatusCode();
    }

}
