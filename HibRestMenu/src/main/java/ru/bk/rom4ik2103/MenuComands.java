package ru.bk.rom4ik2103;

import javax.persistence.EntityManager;

public interface MenuComands {
    public void addDishToMenu(EntityManager em);
    public void deleteDishFromMenu(EntityManager em);
    public void viewAllDishes(EntityManager em);
    public void selectDishesByPrice(EntityManager em);
    public void selectDishesWithDiscount(EntityManager em);

}
