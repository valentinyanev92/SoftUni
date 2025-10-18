package main.repository;

import main.model.Mob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MobRepository extends JpaRepository<Mob, UUID> {

    List<Mob> getAllByAliveOrderByCreatedOnDesc(Boolean alive);
}
