package org.example.softunigamestore.repositories;

import org.example.softunigamestore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findAllByEmailAndPassword(String email, String password);
}
