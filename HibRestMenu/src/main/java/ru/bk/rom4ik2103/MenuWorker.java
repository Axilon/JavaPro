package ru.bk.rom4ik2103;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

/**
 * Created by user on 12.04.2017.
 */
public class MenuWorker implements MenuComands {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addDishToMenu(EntityManager em) {
        System.out.println("Enter dish name");
        String name = sc.nextLine();
        System.out.println("Enter dish price");
        Integer price = Integer.parseInt(sc.nextLine());
        System.out.println("Enter dish weight in grams");
        Integer weight = Integer.parseInt(sc.nextLine());
        System.out.println("Does dish has a discount?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        switch (sc.nextLine()){
            case "1":
                System.out.println("Enter discount value from 1 to 100");
                Integer discount = Integer.parseInt(sc.nextLine());
                createDishWithDiscount(name,price,weight,discount,em);
                break;
            case "2":
                createDishWithOutDiscount(name,price,weight,em);
                break;
            default:
                return;
        }
    }
    private void createDishWithOutDiscount(String name, Integer price, Integer weight, EntityManager em){
        em.getTransaction().begin();
        try{
            Dish dish = new Dish(name, price, weight);
            em.persist(dish);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }
    private void createDishWithDiscount(String name, Integer price, Integer weight, Integer discount, EntityManager em){
        em.getTransaction().begin();
        try{
            DishWithDiscount dish = new DishWithDiscount(name,price,weight,discount);
            em.persist(dish);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }
    }

    @Override
    public void deleteDishFromMenu(EntityManager em) {
        System.out.println("Enter dish id:");
        long id = Long.parseLong(sc.nextLine());

        DishWithDiscount dish = em.find(DishWithDiscount.class, id);
        Dish dish1 = em.find(Dish.class,id);
        if (dish ==null && dish1 == null){
            System.out.println("Dish not found");
            return;
        }
        if(dish!= null) {
            em.getTransaction().begin();
            try {
                em.remove(dish);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
            }
        }else if (dish1 != null){
            em.getTransaction().begin();
            try {
                em.remove(dish1);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
            }
        }

    }
    @Override
    public void viewAllDishes(EntityManager em) {
        Query query = em.createQuery("SELECT c FROM Dish c", Dish.class);
            List<Dish> list = (List <Dish>) query.getResultList();
            for (Dish c : list){
                System.out.println(c);
            }
            query = em.createQuery("SELECT c FROM DishWithDiscount c", DishWithDiscount.class);
        List<DishWithDiscount> list2 = (List <DishWithDiscount>) query.getResultList();
        for (DishWithDiscount c : list2){
            System.out.println(c);
        }
    }

    @Override
    public void selectDishesByPrice(EntityManager em) {
        System.out.println("1: Enter min price");
        double price1 = sc.nextDouble();
        System.out.println("2: Enter max price");
        double price2 = sc.nextDouble();
        System.out.println("Choose:");
        System.out.println("1: To show you dishes with discount");
        System.out.println("2: To show you dishes without discount");
        switch (sc.nextLine()){
            case "1":
                Query query = em.createQuery("SELECT d FROM DishWithDiscount d WHERE d.price>=" + price1 + " AND d.price<=" + price2, DishWithDiscount.class);
                List<DishWithDiscount> menuList = (List<DishWithDiscount>) query.getResultList();

                for (Dish dish : menuList) {
                    System.out.println(dish);
                }
                System.out.println();
                break;
            case "2":
                Query query1 = em.createQuery("SELECT d FROM Dish d WHERE d.price>=" + price1 + " AND d.price<=" + price2, Dish.class);
                List<Dish> menuList2 = (List<Dish>) query1.getResultList();

                for (Dish dish : menuList2) {
                    System.out.println(dish);
                }
                System.out.println();
                break;
            default:
                return;
        }

    }

    @Override
    public void selectDishesWithDiscount(EntityManager em) {
        Query query = em.createQuery("SELECT d FROM DishWithDiscount d WHERE d.discount> 0", DishWithDiscount.class);
        List<DishWithDiscount> menuList = (List<DishWithDiscount>) query.getResultList();

        for (DishWithDiscount dish : menuList) {
            System.out.println(dish);
        }
        System.out.println();
    }

}
