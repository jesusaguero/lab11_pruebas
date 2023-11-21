package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class OwnerServiceTest {

	@Autowired
	private OwnerServiceImpl ownerService;


	@Test
	public void testCreateOwner() {

		String first_name = "Jesus";
		String last_name = "Agüero";
		String Address = "Lima";
		String City = "Lima";
		String telephone = "989679624";
	}

	@Test
	public void testFindByIdOwner(){
		String firstName = "Jesus";
		String lastName = "Agüero";
		String address = "Lima";
		String city = "Lima";
		String telephone = "989679624";

		Owner ownerToCreate = new Owner();
		ownerToCreate.setFirst_name(firstName);
		ownerToCreate.setLast_name(lastName);
		ownerToCreate.setAddress(address);
		ownerToCreate.setCity(city);
		ownerToCreate.setTelephone(telephone);

		Owner createdOwner = ownerService.create(ownerToCreate);

		try{
			Owner foundOwner = ownerService.findById(createdOwner.getId());

			assertNotNull(foundOwner);
			assertEquals(firstName, foundOwner.getFirst_name());
			assertEquals(lastName, foundOwner.getLast_name());
			assertEquals(address, foundOwner.getAddress());
			assertEquals(city, foundOwner.getCity());
			assertEquals(telephone, foundOwner.getTelephone());
		} catch (OwnerNotFoundException e) {
			fail("Owner not found: " + e.getMessage());
		}
	}
}
