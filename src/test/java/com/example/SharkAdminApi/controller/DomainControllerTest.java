package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.repository.DomainRepository;
import com.example.SharkAdminApi.service.DomainService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

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