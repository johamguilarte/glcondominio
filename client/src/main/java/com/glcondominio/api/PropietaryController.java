package com.glcondominio.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.glcondominio.model.Propietary;
import com.glcondominio.service.PropietaryService;

@RestController
@RequestMapping(value = "/propietary")
public class PropietaryController {
    
    @Autowired
    PropietaryService service;
    
    @PostMapping("/create")
    public ResponseEntity<Propietary> create(
        @AuthenticationPrincipal Jwt jwt,
        @RequestBody @NonNull Propietary model) {
        return ResponseEntity.ok(service.create(jwt, model));
    }

    @PostMapping("/update")
    public ResponseEntity<Propietary> update(
        @AuthenticationPrincipal Jwt jwt,
        @RequestBody @NonNull Propietary model) {
        return ResponseEntity.ok(service.update(jwt, model));
    }

    @GetMapping("/get-all")
    @ResponseBody
    public ResponseEntity<List<Propietary>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get-by-id/{id}")
    @ResponseBody
    public ResponseEntity<Propietary> getById(
        @PathVariable @NonNull Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(
        @AuthenticationPrincipal Jwt jwt,
        @PathVariable @NonNull Long id) {
        return ResponseEntity.ok(service.delete(jwt, id));
    }
    
   
    
}
