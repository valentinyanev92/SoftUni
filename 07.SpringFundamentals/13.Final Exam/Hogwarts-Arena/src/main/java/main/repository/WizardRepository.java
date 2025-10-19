package main.repository;

import main.model.House;
import main.model.Wizard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WizardRepository extends JpaRepository<Wizard, UUID> {
    Optional<Wizard> findByUsername(String username);

    List<Wizard> findByHouse(House house);

    // TODO: Add methods if necessary.
}
