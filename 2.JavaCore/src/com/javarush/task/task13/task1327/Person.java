package com.javarush.task.task13.task1327;

public class Person implements RepkaItem {
    private String name;
    private String namePadezh;

    public void pull(Person secondPerson) {
        System.out.printf("%s за %s%s", this.getName(), secondPerson.getNamePadezh(), System.lineSeparator());
    }

    public Person(String name, String namePadezh) {
        this.setName(name);
        this.setNamePadezh(namePadezh);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePadezh() {
        return namePadezh;
    }

    public void setNamePadezh(String namePadezh) {
        this.namePadezh = namePadezh;
    }
}
