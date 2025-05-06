package org.example.services;

import org.example.dao.CatDao;
import org.example.models.Cats;

import java.util.List;

public class CatService {

    private CatDao catsDao = new CatDao();

    public CatService() {
    }

    public Cats findCat(int id) {
        return catsDao.findById(id);
    }

    public void saveCat(Cats cat) {
        catsDao.save(cat);
    }

    public void deleteCat(Cats cat) {
        catsDao.delete(cat);
    }

    public void updateCat(Cats cat) {
        catsDao.update(cat);
    }

    public List<Cats> findAllCats() {
        return catsDao.findAll();
    }

    public Cats findCatById(int id) {
        return catsDao.findCatById(id);
    }

}