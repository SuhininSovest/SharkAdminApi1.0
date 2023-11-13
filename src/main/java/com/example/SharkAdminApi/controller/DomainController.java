package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.DomainDTO;
import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.repository.DomainRepository;
import com.example.SharkAdminApi.service.DomainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class DomainController {
    private final DomainRepository domainRepository;
    DomainService domainService;

    //Get List with Domains
    @GetMapping("/getDomains")
    List<Domain> all() {
        return domainRepository.findAll();
    }

    //Get one domain from list
    @GetMapping("/getDomain/{domainId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Optional<Domain> readById(@PathVariable Long domainId) {
        return domainService.readDomainById(domainId);
    }

    //Create domain
    @PostMapping("/domain/create")
    public void createDomain(@RequestBody DomainDTO dto) {
        new ResponseEntity<>(domainService.create(dto), HttpStatus.CREATED);
    }

    //delete domain
    @DeleteMapping("/domain/delete/{id}")
    void deleteDomain(@PathVariable Long id) {
        domainRepository.deleteById(id);
    }
}
