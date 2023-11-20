package com.example.SharkAdminApi.service;


import com.example.SharkAdminApi.dto.DomainDTO;
import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.repository.DomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class DomainService {
    private final DomainRepository domainRepository;

    //search domain by Id
    public Optional<Domain> readDomainById(Long domainId) {
        return domainRepository.findById(domainId);
    }
    @Transactional
    public Domain create(DomainDTO dto) {
        return domainRepository.save(Domain.builder()
                .nameDomain(dto.getNameDomain())
                .build());
    }
    @Transactional
    public void update(DomainDTO domainDTO, Long id){
        Domain domain = domainRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Domain with id " + id + " does not exist."));
        domain.setNameDomain(domainDTO.getNameDomain());
        domainRepository.save(domain);
    }
    public List<Domain> readDomainAll() {
        return domainRepository.findAll();
    }
    public void delete(Long id) {
        domainRepository.deleteById(id);
    }















}
