/** ===========================================================================
 * Program : CustomerRepository.java
 * Function: The entity of the actors to hold the actors information
 * @author : Bill Huang
 * Date    : Dec 28, 2019
 ** ========================================================================= */

package com.jsonar.DVDRentals.dao;

import com.jsonar.DVDRentals.entity.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends MongoRepository<Customer, String> {

}
