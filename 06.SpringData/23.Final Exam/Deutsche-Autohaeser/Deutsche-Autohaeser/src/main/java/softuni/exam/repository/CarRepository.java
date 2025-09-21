package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.CarType;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    Car getCarById(Long id);

    @Query("select c from Car as c where c.carType = :carType and c.mileage < :carMileage order by c.mileage desc")
    List<Car> exportCars(CarType carType, Integer carMileage);
}
