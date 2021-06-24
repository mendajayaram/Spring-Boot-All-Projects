package com.nt.jai.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.jai.model.Address;

public interface AddressRepository extends MongoRepository<Address, String> {

}
