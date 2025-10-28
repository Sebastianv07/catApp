package com.catappback.backend.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.catappback.backend.service.GatoService;
import lombok.*;

@RestController
@RequestMapping("/api/gatos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GatoController {
    private final GatoService gatoService;

    @GetMapping("/breeds")
    public List<Map<String, Object>> getBreeds() {
        return gatoService.getAllBreeds();
    }

    @GetMapping("/breeds/{breedId}")
    public Map<String, Object> getBreedById(@PathVariable String breedId) {
        return gatoService.getBreedById(breedId);
    }

    @GetMapping("/breeds/search")
    public List<Map<String, Object>> searchBreeds(@RequestParam String q) {
        return gatoService.searchBreeds(q);
    }
}
