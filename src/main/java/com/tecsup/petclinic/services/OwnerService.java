package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {
    Owner create(Owner owner);
    Owner update(Owner owner);

    /**
     * Deletes an owner by ID.
     *
     * @param id the ID of the owner to delete
     * @throws OwnerNotFoundException if the owner with the specified ID is not found
     */
    void delete(Long id) throws OwnerNotFoundException;

    /**
     * Finds an owner by ID.
     *
     * @param id the ID of the owner to find
     * @return the found owner
     * @throws OwnerNotFoundException if the owner with the specified ID is not found
     */
    Owner findById(Long id) throws OwnerNotFoundException;
}
