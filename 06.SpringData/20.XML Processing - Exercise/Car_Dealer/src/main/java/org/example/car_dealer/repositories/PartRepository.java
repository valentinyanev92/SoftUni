package org.example.car_dealer.repositories;

import org.example.car_dealer.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<Part,Long> {

    Part getPartById(Long randomId);
}
