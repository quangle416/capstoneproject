package org.perscholas.capstoneproject.dao;

import org.perscholas.capstoneproject.models.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepoI extends JpaRepository<ItemOrder, Integer> {
}
