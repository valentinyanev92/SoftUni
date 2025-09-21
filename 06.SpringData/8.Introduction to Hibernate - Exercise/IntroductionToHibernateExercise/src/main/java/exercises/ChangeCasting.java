package exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ChangeCasting {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            Query query = em.createQuery("update Town as t set t.name = upper(t.name) where length(t.name) <= 5");
            int affectedRows = query.executeUpdate();
            em.getTransaction().commit();

            System.out.println(affectedRows + " rows affected");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

//        TypedQuery<Town> query = em.createQuery("SELECT t FROM Town AS t", Town.class);
//        List<Town> towns = query.getResultList();
//        towns.forEach(town -> {
//            if (town.getName().length() > 5) {
//                em.detach(town);
//            } else {
//                town.setName(town.getName().toUpperCase());
//                em.persist(town);
//            }
//        });
//
//        em.getTransaction().commit();
//        em.close();
    }
}
