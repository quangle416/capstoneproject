package org.perscholas.capstoneproject.dao;

import org.perscholas.capstoneproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepoI extends JpaRepository<Product, Integer> {
}
