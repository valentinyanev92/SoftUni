package exercises;

import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the town: ");

        String townName = scanner.nextLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Town> townQuery = em.createQuery("SELECT t FROM Town t WHERE t.name = :townName", Town.class);
        townQuery.setParameter("townName", townName);
        Town town = townQuery.getSingleResult();

        TypedQuery<Address> addressQuery = em.createQuery("SELECT a FROM Address a WHERE a.town = :town", Address.class);
        addressQuery.setParameter("town", town);
        List<Address> addresses = addressQuery.getResultList();

        em.getTransaction().begin();

        try {
            for (Address address : addresses) {
                em.remove(address);
            }

            em.remove(town);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error deleting town");
        }
    }
}
