package org.iesch.ad.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.iesch.ad.modelo.Person;

public class PersonDAO {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public PersonDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public Person busca(Person person) {
        return entityManager.find(Person.class, person.getDni());
    }

    public void guarda(Person person) {
        try {
            transaction.begin();
            entityManager.persist(person);
            transaction.commit();
            System.out.println("\tSe ha insertado correctamente");
        } catch (Exception e) {
            System.out.println("\tNo se ha insertado correctamente");
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void borra(Person person) {
        try {
            transaction.begin();
            Person personTmp = entityManager.merge(person);
            entityManager.remove(personTmp);
            transaction.commit();
            System.out.println("Se ha borrado correctamente");
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

}
