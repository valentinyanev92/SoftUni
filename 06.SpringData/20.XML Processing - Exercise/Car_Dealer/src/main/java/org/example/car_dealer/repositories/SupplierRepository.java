package org.example.car_dealer.repositories;

import org.example.car_dealer.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Supplier getSupplierById(Long randomId);
}
