package ru.bk.rom4ik2103;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    static EntityManagerFactory emf;
    static EntityManager em;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        emf = Persistence.createEntityManagerFactory("JPATest");
        em = emf.createEntityManager();
        MenuWorker dao = new MenuWorker();
        try {
            while (true) {
                String s=chooseOperations(sc);
                switch (s) {
                    case "1":
                        dao.viewAllDishes(em);
                        break;
                    case "2":
                        dao.addDishToMenu(em);
                        break;
                    case "3":
                        dao.deleteDishFromMenu(em);
                        break;
                    case "4":
                        dao.selectDishesByPrice(em);
                        break;
                    case "5":
                        dao.selectDishesWithDiscount(em);
                        break;
                    case "6":
                        dao.selectDishesByWeight(em);
                        break;
                    case "7":
                        dao.findDishById(em);
                        break;
                    default:
                        return;
                }
            }
        } finally {
            sc.close();
            em.close();
            emf.close();
        }
    }

    private static String chooseOperations(Scanner sc){
        System.out.println("1: Show menu");
        System.out.println("2: Add new dish");
        System.out.println("3: Delete dish");
        System.out.println("4: Show dishes by price");
        System.out.println("5: Show dishes with discount");
        System.out.println("6: Select dishes by weight");
        System.out.println("7: Select dishes by id");
        System.out.print("-> ");

        return sc.nextLine();
    }

    }

