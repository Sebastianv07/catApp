package com.catappback.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import java.util.*;

@Service
public class GatoService {
    @Value("${thecatapi.url}")
    private String baseUrl;
    @Value("${thecatapi.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private HttpEntity<String> createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        return new HttpEntity<>(headers);
    }

    public List<Map<String, Object>> getAllBreeds() {
        ResponseEntity<List> response = restTemplate.exchange(baseUrl + "/breeds", HttpMethod.GET, createHeaders(), List.class);
        return response.getBody();
    }

    public Map<String, Object> getBreedById(String breedId) {
        List<Map<String, Object>> breeds = getAllBreeds();
        return breeds.stream().filter(b -> breedId.equals(b.get("id"))).findFirst().orElse(null);
    }

    public List<Map<String, Object>> searchBreeds(String query) {
        String url = baseUrl + "/breeds/search?q=" + query;
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, createHeaders(), List.class);
        return response.getBody();
    }
}
