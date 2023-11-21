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

import java.util.Optional;

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

        Owner ownerToUpdate = new Owner();
        ownerToUpdate.setFirst_name("Renzo");
        ownerToUpdate.setLast_name("Remuzgo");
        ownerToUpdate.setAddress("Ate");
        ownerToUpdate.setCity("Lima");
        ownerToUpdate.setTelephone("96487598");

        when(ownerRepository.save(any(Owner.class))).thenReturn(ownerToUpdate);

        Owner updatedOwner = ownerService.create(ownerToUpdate);

        // Assert
        assertNotNull(updatedOwner);
        assertEquals("Renzo", updatedOwner.getFirst_name());



    }

    @Test
    public void testDeleteOwner() throws OwnerNotFoundException {
    }

    @Test
    public void testFindByIdOwner() throws OwnerNotFoundException {

        Long ownerId = 1L ;
        Owner ownerToReturn = new Owner();
        ownerToReturn.setId(ownerId);
        ownerToReturn.setFirst_name("Jeremy");

        when(ownerRepository.findById(ownerId)).thenReturn(Optional.of(ownerToReturn));

        Owner foundOwner = ownerService.findById(ownerId);

        assertNotNull(foundOwner);
        assertEquals("Jeremy", foundOwner.getFirst_name());
    }


}
