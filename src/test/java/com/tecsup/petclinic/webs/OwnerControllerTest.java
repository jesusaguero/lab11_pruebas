package com.tecsup.petclinic.webs;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.domain.PetTO;
import com.tecsup.petclinic.entities.Owner;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 *
 */
@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
public class OwnerControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateOwner() throws Exception{

        String first_name = "Jesus";
        String last_name = "Agüero";
        String address = "Sta Anita";
        String city = "Lima";
        String telephone = "989679624";

        OwnerTO newOwnerTO = new OwnerTO();
        newOwnerTO.setfirstname(first_name);
        newOwnerTO.setlastname(last_name);
        newOwnerTO.setaddress(address);
        newOwnerTO.setcity(city);
        newOwnerTO.settelephone(telephone);

        mockMvc.perform(post("/owners")
                .content((om.writeValueAsString(newOwnerTO))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())

                .andExpect(jsonPath("$.firstname", is(first_name)))
                .andExpect(jsonPath("$.lastname", is(last_name)))
                .andExpect(jsonPath("$.address", is(address)))
                .andExpect(jsonPath("$.city", is(city)))
                .andExpect(jsonPath("$.telephone", is(telephone))));


    }
}