package org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.entities.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("labs");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Bike bike = new Bike();
        bike.setModel("BMX");
        em.persist(bike);

        Car car = new Car();
        car.setModel("BMW");
        car.setFuelType("Gasoline");
        car.setSeats(4);
        em.persist(car);

        Plane plane = new Plane();
        plane.setModel("Boeing 771");
        plane.setFuelType("Gasoline");
        plane.setPassengerCapacity(1000);
        em.persist(plane);

        Truck truck = new Truck();
        truck.setModel("Volvo 70");
        truck.setFuelType("Gasoline");
        truck.setLoadCapacity(2.5);
        em.persist(truck);

        em.getTransaction().commit();


        TypedQuery<Vehicle> query = em.createQuery("select v from Vehicle v", Vehicle.class);
        List<Vehicle> resultList = query.getResultList();

        System.out.println(resultList.size());
    }
}