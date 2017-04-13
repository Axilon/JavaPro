package ru.bk.rom4ik2103;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "Menu")
@DiscriminatorValue(value = "With_Discount")
public class DishWithDiscount extends Dish {
    @Column(name = "discount_value")
    private Integer discount;

    public DishWithDiscount() {
    }

    public DishWithDiscount(String name, Integer price, Integer weight, Integer discount) {
        super(name, price, weight);
        this.discount=discount;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
