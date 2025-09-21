package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Dealership;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership,Integer> {

    Dealership getReferenceById(Long id);

    Dealership getDealershipById(Long id);
}
