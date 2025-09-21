package org.example.car_dealer.repositories;

import org.example.car_dealer.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {

    boolean existsByCar_Id(Long id);
}
