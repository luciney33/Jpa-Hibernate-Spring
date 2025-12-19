package org.example.jpaspring.ui;
import org.example.jpaspring.domain.model.TypeDTO;
import org.example.jpaspring.domain.service.TypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestType {
    private final TypeService typeService;

    public RestType(TypeService typeService) {
        this.typeService = typeService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/types")
    public List<TypeDTO> getAll() {
        return typeService.getAllTypes();
    }
}

