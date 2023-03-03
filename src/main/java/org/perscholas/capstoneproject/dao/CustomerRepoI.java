package org.perscholas.capstoneproject.dao;

import org.perscholas.capstoneproject.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepoI extends JpaRepository<Customer, Integer> {

//    Hibernate SQL
//    @Query("select firstName from customer where firstname=?", nativeQuery = true)
    //created method for finding customer by name
//    Optional<Customer> findByFirstName(String firstName);
}
