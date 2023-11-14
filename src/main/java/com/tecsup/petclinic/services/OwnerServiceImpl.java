package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OwnerServiceImpl implements OwnerService{

   OwnerRepository ownerRepository;

   public OwnerServiceImpl(OwnerRepository ownerRepository) {this. ownerRepository = ownerRepository;}

   @Override
   public Owner create(Owner owner) { return ownerRepository.save(owner);}}


