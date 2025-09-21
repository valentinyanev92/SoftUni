package org.example.softunigamestore.repositories;

import org.example.softunigamestore.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Object getByTitle(String title);
}
