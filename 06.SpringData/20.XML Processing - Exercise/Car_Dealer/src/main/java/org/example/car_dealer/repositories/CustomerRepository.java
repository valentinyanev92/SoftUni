package org.example.car_dealer.repositories;

import org.example.car_dealer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer getCustomersById(Long customerId);

    @Query("select c from Customer c order by c.birthDate asc, c.isYoungDriver asc ")
    List<Customer> getAllCustomersOrderByBirthDate();
}
