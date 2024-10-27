package ru.ssau.lab1.dao;

import ru.ssau.lab1.model.Car;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CarDao {

    public void create(Car car) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(car);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Car get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Car car = entityManager.find(Car.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return car;
    }

    public List<Car> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Car> cars = entityManager.createQuery("select c from Car c", Car.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return cars;
    }

    public void update(Long id, Car newCarData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Car car = entityManager.find(Car.class, id);
        if (car != null) {
            car.setModelName(newCarData.getModelName());
            car.setBrand(newCarData.getBrand());
            car.setOwner(newCarData.getOwner());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Car car = entityManager.find(Car.class, id);
        if (car != null) {
            entityManager.remove(car);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
