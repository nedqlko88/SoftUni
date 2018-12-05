package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CodeFirstApp {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.
                        createEntityManagerFactory("code_first");

        EntityManager em = emf.createEntityManager();


    }
}
