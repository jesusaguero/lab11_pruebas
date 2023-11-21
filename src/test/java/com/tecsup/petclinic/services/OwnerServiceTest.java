package com.tecsup.petclinic.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
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
	public void testUpdateOwner () {

		String first_name = "Renzo";
		String last_name = "Remuzgo";
		String address = "Lima";
		String city = "Lima";
		String telephone = "96487598";

	}

}
