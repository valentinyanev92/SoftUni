import entities.WizardDeposit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        EntityManager em= emf.createEntityManager();

        WizardDeposit deposit=new WizardDeposit();
        deposit.setFirstName("Jack");
        deposit.setLastName("Smith");
        deposit.setAge(21);
        deposit.setDepositAmount(BigDecimal.valueOf(1000));
        deposit.setDepositInterest(BigDecimal.valueOf(500));

        em.getTransaction().begin();
        em.persist(deposit);
        em.getTransaction().commit();
        em.close();
    }
}
