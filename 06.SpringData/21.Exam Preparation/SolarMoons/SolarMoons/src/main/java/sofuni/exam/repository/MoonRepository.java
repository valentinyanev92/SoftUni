package sofuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sofuni.exam.models.entity.Moon;
import sofuni.exam.models.enums.Type;

import java.util.List;

@Repository
public interface MoonRepository extends JpaRepository<Moon,Integer> {

//    @Query("select m.name, m.planet.name, m.radius, m.discoverer from Moon as m where m.radius >= :minRadius and m.radius <= :maxRadius order by m.name asc")
    @Query("select m from Moon as m where m.planet.type = :type and m.radius >= :minRadius and m.radius <= :maxRadius order by m.name asc")
    List<Moon> exportable(Type type, Double minRadius, Double maxRadius);
}
