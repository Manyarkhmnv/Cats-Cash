package org.example.services;

import org.example.dao.OwnerDao;
import org.example.models.Cats;
import org.example.models.Owners;

import java.util.List;

public class OwnerService {

    private OwnerDao ownerDao = new OwnerDao();

    public OwnerService() {
    }

    public Owners findOwner(int id) {
        return ownerDao.findById(id);
    }

    public void saveOwner(Owners owner) {
        ownerDao.save(owner);
    }

    public void deleteOwner(Owners owner) {
        ownerDao.delete(owner);
    }

    public void updateOwner(Owners owner) {
        ownerDao.update(owner);
    }

    public List<Owners> findAllOwners() {
        return ownerDao.findAll();
    }

    public Cats findOwnerById(int id) {
        return ownerDao.findOwnerById(id);
    }


}