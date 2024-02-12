package com.glcondominio.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glcondominio.model.Tower;
import com.glcondominio.service.TowerService;

@RestController
@RequestMapping(
    value = "/tower", 
    consumes = "application/json")
public class TowerController {
    
    @Autowired
    TowerService service;
    
    @PostMapping("/create")
    public ResponseEntity<Tower> create(@RequestBody @NonNull Tower model) {
        return ResponseEntity.ok(service.create(model));
    }

    @PostMapping("/update")
    public ResponseEntity<Tower> update(@RequestBody @NonNull Tower model) {
        return ResponseEntity.ok(service.update(model));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Tower>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Tower> getById(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable @NonNull Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
    
}
