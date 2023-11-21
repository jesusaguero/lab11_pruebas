package com.tecsup.petclinic.services;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;

@SpringBootTest
public class OwnerServiceMockitoTest {

    @InjectMocks
    private OwnerServiceImpl ownerService;

    @Mock
    private OwnerRepository ownerRepository;

    @Test
    public void testCreateOwner() {
        // Arrange
        Owner ownerToCreate = new Owner();
        ownerToCreate.setFirst_name("Jesus");
        ownerToCreate.setLast_name("Agüero");
        ownerToCreate.setAddress("Sta Anita");
        ownerToCreate.setCity("Lima");
        ownerToCreate.setTelephone("989679624");

        // Simulate the repository save behavior
        when(ownerRepository.save(any(Owner.class))).thenReturn(ownerToCreate);

        // Act
        Owner createdOwner = ownerService.create(ownerToCreate);

        // Assert
        assertNotNull(createdOwner);
        assertEquals("Jesus", createdOwner.getFirst_name());
    }

    @Test
    public void testUpdateOwner() {
    }

    @Test
    public void testDeleteOwner() throws OwnerNotFoundException {
    }

    @Test
    public void testFindByIdOwner() throws OwnerNotFoundException {
    }


}
