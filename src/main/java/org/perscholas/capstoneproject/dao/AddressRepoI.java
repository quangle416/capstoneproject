package org.perscholas.capstoneproject.dao;

import org.perscholas.capstoneproject.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepoI extends JpaRepository<Address, Integer> {
}
