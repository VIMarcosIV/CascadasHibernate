package org.iesch.ad.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.iesch.ad.modelo.Asociacion;
import org.iesch.ad.modelo.IdCard;
import org.iesch.ad.modelo.Person;

public class AsociacionDAO {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public AsociacionDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public Asociacion busca(Asociacion asociacion) {
        return entityManager.find(Asociacion.class, asociacion.getId());
    }

    public void guarda(Asociacion asociacion) {
        try {
            transaction.begin();
            entityManager.persist(asociacion);
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

    public void borra(Asociacion asociacion) {
        try {
            transaction.begin();
            Asociacion asociacionTmp = entityManager.merge(asociacion);
            entityManager.remove(asociacionTmp);
            transaction.commit();
            System.out.println("Se ha borrado correctamente");
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

}
