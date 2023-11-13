package com.example.SharkAdminApi.service;


import com.example.SharkAdminApi.dto.DomainDTO;
import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.repository.DomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class DomainService {
    private final DomainRepository domainRepository;

    //search domain by Id
    public Optional<Domain> readDomainById(Long domainId) {
        return domainRepository.findById(domainId);
    }
    public Domain create(DomainDTO dto) {
        return domainRepository.save(Domain.builder()
                .nameDomain(dto.getNameDomain())
                .build());

    }















}
