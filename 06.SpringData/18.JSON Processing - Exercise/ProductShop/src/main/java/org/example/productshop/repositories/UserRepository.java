package org.example.productshop.repositories;

import org.example.productshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllBySellingNotNullOrderByLastNameAscFirstNameAsc();
    List<User> findAllBySellingNotEmptyOrderByLastNameAscFirstNameAsc();

    @Query("select u from User as u where size(u.selling) >= 1 order by size(u.selling) desc")
    List<User> getAll();
}
