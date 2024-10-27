package ru.ssau.lab1.dao;

import ru.ssau.lab1.model.Owner;
import jakarta.persistence.EntityManager;

import java.util.List;

public class OwnerDao {
    public void create(Owner owner) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(owner);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Owner get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Owner owner = entityManager.find(Owner.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return owner;
    }

    public List<Owner> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Owner> owners = entityManager.createQuery("select o from Owner o", Owner.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return owners;
    }

    public void update(Long id, Owner newOwnerData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Owner owner = entityManager.find(Owner.class, id);
        if (owner != null) {

        }
        owner.setFirstName(newOwnerData.getFirstName());
        owner.setLastName(newOwnerData.getLastName());
        owner.setBirthdate(newOwnerData.getBirthdate());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Owner owner = entityManager.find(Owner.class, id);
        if (owner != null) {
            entityManager.remove(owner);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
