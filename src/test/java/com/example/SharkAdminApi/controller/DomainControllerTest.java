package com.example.SharkAdminApi.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DomainController.class)
public class DomainControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    DomainRepository domainRepository;

    @MockBean
    DomainService domainService;

    @Test
    public void whenValidId_thenDomainShouldBeFound() throws Exception {
        Long id = 1L;
        Domain domain = Domain.builder()
                .domainId(id)
                .nameDomain("Test")
                .build();
        Optional<Domain> domainOpt = Optional.of(domain);
        when(domainService.readDomainById(id)).thenReturn(domainOpt);

        mvc.perform(get("/getDomain/"+id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nameDomain", is(domain.getNameDomain())));
    }
}