package com.example.SharkAdminApi.service;


import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.repository.DomainRepository;

import java.util.Optional;

public class ServiceDomain {
    private final DomainRepository domainRepository;

    public ServiceDomain(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

//    public Optional<Domain> readDomainById(Long domainId) {
//        return domainRepository.findById(domainId);
//    }
}
