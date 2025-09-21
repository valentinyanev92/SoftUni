package exercises;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AddressesWithEmployeeCount {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Address> query = em.createQuery("select a from Address a order by size(a.employees) desc", Address.class);
        query.setMaxResults(10);
        List<Address> addresses = query.getResultList();

        for (Address address : addresses) {
            System.out.println(address.getText() + ", " + address.getTown().getName() + " - "+ address.getEmployees().size() + " employees");
        }


    }
}
