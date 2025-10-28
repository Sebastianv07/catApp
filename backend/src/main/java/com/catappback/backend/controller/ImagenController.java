package com.catappback.backend.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.catappback.backend.service.ImagenService;
import lombok.*;

@RestController
@RequestMapping("/api/imagenes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ImagenController {
    private final ImagenService imagenService;

    @GetMapping("/imagesbybreedid")
    public List<Map<String, Object>> getImagesByBreed(@RequestParam String breedId) {
        return imagenService.getImagesByBreed(breedId);
    }
}
