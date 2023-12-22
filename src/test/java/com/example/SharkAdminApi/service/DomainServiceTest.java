package com.example.SharkAdminApi.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class DomainServiceTest {

    @Mock
    private DomainRepository domainRepository;

    @InjectMocks
    private DomainService domainService;

    @Test
    public void whenValidId_thenDomainShouldBeFound() {
        Long id = 1L;
        Domain domain = Domain.builder()
                .domainId(id)
                .nameDomain("Test")
                .build();
        Optional<Domain> domainOpt = Optional.of(domain);
        Mockito.when(domainRepository.findById(id)).thenReturn(domainOpt);

        Optional<Domain> found = domainService.readDomainById(id);
        assertThat(found).isNotNull();
        assertThat(found.get().getNameDomain()).isEqualTo("Test");
    }
}