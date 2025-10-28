package com.catappback.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.*;

@Service
public class ImagenService {
    @Value("${thecatapi.url}")
    private String baseUrl;
    @Value("${thecatapi.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private HttpEntity<String> headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        return new HttpEntity<>(headers);
    }

    public List<Map<String, Object>> getImagesByBreed(String breedId) {
        String url = baseUrl + "/images/search?breed_ids=" + breedId + "&limit=5";
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, headers(), List.class);
        return response.getBody();
    }
}
