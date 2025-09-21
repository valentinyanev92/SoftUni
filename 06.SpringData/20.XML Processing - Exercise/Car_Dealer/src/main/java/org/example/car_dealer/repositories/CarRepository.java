package org.example.car_dealer.repositories;

import org.example.car_dealer.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    Car getCarById(Long id);
}
