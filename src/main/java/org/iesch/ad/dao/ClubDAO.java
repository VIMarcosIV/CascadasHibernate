package org.iesch.ad.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.iesch.ad.modelo.Asociacion;
import org.iesch.ad.modelo.Club;
import org.iesch.ad.modelo.IdCard;

public class ClubDAO {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public ClubDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public Club busca(Club club) {
        return entityManager.find(Club.class, club.getId());
    }

    public void guarda(Club club) {
        try {
            transaction.begin();
            entityManager.persist(club);
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

    public void borra(Club club) {
        try {
            transaction.begin();
            Club clubTmp = entityManager.merge(club);
            entityManager.remove(clubTmp);
            transaction.commit();
            System.out.println("Se ha borrado correctamente");
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

}
