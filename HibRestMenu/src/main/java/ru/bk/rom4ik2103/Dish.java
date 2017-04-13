package ru.bk.rom4ik2103;

import javax.persistence.*;

@Entity
@Table (name = "Menu")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "discriminator",
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue(value = "No_Discount")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;
    @Column(name = "Dish_name")
    private String name;

    private Integer price;

    private Integer weight;

    public Dish() {
    }

    public Dish(String name, Integer price, Integer weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
