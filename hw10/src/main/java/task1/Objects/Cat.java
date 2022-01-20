package task1.Objects;

import task1.Annotations.Column;
import task1.Entity;

public class Cat extends Entity {

    @Column(name = "cat_name")
    private String name;
    @Column(name = "cat_age")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}