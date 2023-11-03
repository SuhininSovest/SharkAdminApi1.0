package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.repository.DomainRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DomainController {
    private final DomainRepository domainRepository;

    public DomainController(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    //Get List with Domains
    @GetMapping("/getDomains")
    List<Domain> all() {
        return domainRepository.findAll();
    }

    //Get one domain from list
//    @GetMapping("/getDomain/{domainId}")
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Optional<Domain> readById(@PathVariable Long domainId) {
//        return domainRepository.readDomainById(domainId);
//    }

    //Create domain
    @PostMapping("/domain/create")
    public Domain newEmployee(@RequestBody Domain newDomain) {
        return domainRepository.save(newDomain);
    }

    //delete domain
    @DeleteMapping("/domain/delete/{id}")
    void deleteEmployee(@PathVariable Long id) {
        domainRepository.deleteById(id);
    }


}
