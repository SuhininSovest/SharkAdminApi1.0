package com.example.SharkAdminApi.service;


import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.model.User;
import com.example.SharkAdminApi.repository.DomainRepository;

import java.util.Optional;

public class DomainService {
    private final DomainRepository domainRepository;

    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    //search domain by Id
    public Optional<Domain> readDomainById(Long domainId) {
        return domainRepository.findById(domainId);
    }


}
