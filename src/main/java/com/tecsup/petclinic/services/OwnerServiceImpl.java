package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OwnerServiceImpl implements OwnerService {

   private final OwnerRepository ownerRepository;

   public OwnerServiceImpl(OwnerRepository ownerRepository) {
      this.ownerRepository = ownerRepository;
   }

   @Override
   public Owner create(Owner owner) {
      Owner createdOwner = ownerRepository.save(owner);
      log.info("Owner created: {}", createdOwner);
      return createdOwner;
   }

   @Override
   public Owner update(Owner owner) {
      Owner updatedOwner = ownerRepository.save(owner);
      log.info("Owner updated: {}", updatedOwner);
      return updatedOwner;
   }

   @Override
   public void delete(Long id) throws OwnerNotFoundException {
      Owner owner = findById(id);
      ownerRepository.delete(owner);
      log.info("Owner deleted: {}", owner);
   }

   @Override
   public Owner findById(Long id) throws OwnerNotFoundException {
      Optional<Owner> owner = ownerRepository.findById(id);

      if (owner.isEmpty()) {
         throw new OwnerNotFoundException("Record not found...!");
      }

      return owner.get();
   }

   @Override
   public void deleteOwner(long ownerIdToDelete) {

   }
}
