package ru.bk.rom4ik2103;

/**
 * Created by user on 31.03.2017.
 */
public class SomeOne {
    private String name;
    private String surName;
    private int age;
    private  String answer1;
    private String answer2;

    public SomeOne(String name, String surName, int age, String answer1, String answer2) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.answer1 = answer1;
        this.answer2 = answer2;
    }

    public SomeOne() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    @Override
    public String toString() {
        return "User<br>" +
                "<strong>First name= </strong>" + name + "<br>" +
                "<strong>Second name= </strong>" + surName + "<br>" +
                "<strong>Age= </strong>" + age + "<br>" +
                "<strong>What is your sex?</strong><br>" + answer1 + "<br>" +
                "<strong>So you like java?</strong><br>" + answer2 + "<br><br>";
    }
}
