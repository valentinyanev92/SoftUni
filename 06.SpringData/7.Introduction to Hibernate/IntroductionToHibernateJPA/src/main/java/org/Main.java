package org;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.entities.Student;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Student student = new Student();
        student.setName("Jones");
        em.persist(student);

        em.getTransaction().commit();
        em.close();
    }
}
