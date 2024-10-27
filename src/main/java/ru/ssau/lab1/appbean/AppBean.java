package ru.ssau.lab1.appbean;


import ru.ssau.lab1.dao.DaoUtil;
import ru.ssau.lab1.dao.CarDao;
import ru.ssau.lab1.dao.OwnerDao;
import ru.ssau.lab1.model.Car;
import ru.ssau.lab1.model.Owner;

import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AppBean {

    private final CarDao carDao = new CarDao();
    private final OwnerDao ownerDao = new OwnerDao();

    public void createCar(Car car, Long ownerId) {
        Owner owner = ownerDao.get(ownerId);
        if (owner == null)
            return;
        car.setOwner(owner);
        carDao.create(car);
    }

    public void createOwner(Owner owner) {
        ownerDao.create(owner);
    }

    public List<Car> getAllCars() {
        return carDao.getAll();
    }

    public Car getCarById(Long id) {
        return carDao.get(id);
    }

    public List<Owner> getAllOwners() {
        return ownerDao.getAll();
    }

    public Owner getOwnerById(Long id) {
        return ownerDao.get(id);
    }

    public void updateCar(Long carId, Car newCarData, Long ownerId) {
        Owner owner = ownerDao.get(ownerId);
        if (owner == null)
            return;
        newCarData.setOwner(owner);
        carDao.update(carId, newCarData);
    }

    public void updateOwner(Long ownerId, Owner newOwnerData) {
        ownerDao.update(ownerId, newOwnerData);
    }

    public void deleteCar(Long carId) {
        carDao.delete(carId);
    }

    public void deleteOwner(Long ownerId) {
        Owner owner = getOwnerById(ownerId);
        if (owner == null)
            return;
        owner.getCars().forEach(car -> this.deleteCar(car.getId()));
        DaoUtil.refresh();
        ownerDao.delete(ownerId);
    }
}
