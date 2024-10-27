package ru.ssau.lab1.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoUtil {
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("postgres-cars");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void refresh() {
        entityManagerFactory.close();
        entityManagerFactory = Persistence.createEntityManagerFactory("postgres-cars");
    }
}
