package com.tecsup.petclinic.webs;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.petclinic.mapper.PetMapper;
import com.tecsup.petclinic.repositories.PetRepository;
import com.tecsup.petclinic.services.PetService;
import com.tecsup.petclinic.util.TObjectCreator;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class OwnerControllerMockitoTest {
    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetRepository petRepository;

    @MockBean
    private PetService petService;

    PetMapper mapper = Mappers.getMapper(PetMapper.class);

    @BeforeEach
    void setUp() {
        // Initialize RestAssured
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testCreateOwner() throws Exception{

        OwnerTO newOwnerTO = TObjectCreator.newOwnerTO();

        Owner newOwner = this.mapper.toOwner(newOwnerTO);

        Mockito.when(ownerService.create(newOwner))
                .thenReturn(newOwner);

        mockMvc.perform(post("/owners")
                        .content(om.writeValueAsString(newOwnerTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())

                .andExpect(jsonPath("$.firstname", is(first_name)))
                .andExpect(jsonPath("$.lastname", is(last_name)))
                .andExpect(jsonPath("$.address", is(address)))
                .andExpect(jsonPath("$.city", is(city)))
                .andExpect(jsonPath("$.telephone", is(telephone)));
    }
}