package org.example;

import org.example.models.Cats;
import org.example.models.Owners;
import org.example.services.CatService;
import org.example.services.OwnerService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        // СОЗДАНИЕ ХОЗЯЕВ
        OwnerService ownerService = new OwnerService();
        Owners Pasha = new Owners(1,"Pasha","Ivanov");
        ownerService.saveOwner(Pasha);
        Owners Maks = new Owners(2,"Maks","Akimtsov");
        ownerService.saveOwner(Maks);
        Owners Lesha = new Owners(3,"Lesha","VASHCHENKOV");
        ownerService.saveOwner(Lesha);

        // СОЗДАНИЕ КОТИКОВ
        CatService cats = new CatService();
        Cats nastya = new Cats(1, "Nastya", "Kamenskich", "blue", Pasha);
        cats.saveCat(nastya);
        Cats masha = new Cats(2, "Masha", "red", "red", Lesha);
        cats.saveCat(masha);
        Cats vika = new Cats(3, "Anna", "Red", "blue", Maks);
        cats.saveCat(vika);

        // ДОБАВЛЕНИЕ ДРУЗЕЙ
        masha.addFriend(nastya, 0);
        vika.addFriend(masha, 1);
        vika.addFriend(nastya, 2);

        // ОБНОВЛЕНИЕ ИНФОРМАЦИИ
        Pasha.setName("Pavel");
        ownerService.updateOwner(Pasha);
        vika.setColor("Red");
        cats.saveCat(vika);

        // УДАЛЕНИЕ ИНФОРМАЦИИ
        ownerService.deleteOwner(Pasha);
        cats.deleteCat(nastya);
        masha.deleteFriend(0L);
    }
}
