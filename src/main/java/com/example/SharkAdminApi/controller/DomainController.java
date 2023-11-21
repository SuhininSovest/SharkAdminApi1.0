package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.DomainDTO;
import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.service.DomainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/domains")
public class DomainController {
    private final DomainService domainService;

    //Get List with Domains
    @GetMapping("/get/all")
    List<Domain> all() {
        return domainService.readDomainAll();
    }

    //Get one domain from list
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Optional<Domain> readById(@PathVariable Long id) {
        return domainService.readDomainById(id);
    }

    //Create domain
    @PostMapping("/create")
    public void createDomain(@RequestBody DomainDTO dto) {
        new ResponseEntity<>(domainService.create(dto), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public void updateDomain(@RequestBody DomainDTO domainDTO, @PathVariable Long id) {
        domainService.update(domainDTO, id);
    }

    //delete domain
    @Transactional
    @DeleteMapping("/delete/{id}")
    void deleteDomain(@PathVariable Long id) {
        domainService.delete(id);
    }
}
