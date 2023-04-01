package com.example.demo;


import jakarta.persistence.*;

//«машина»: ID, Вид техники (например, мультиварка), Группа техники (например, бытовые
//приборы), Дата ввоза на склад, Дата вывоза со склада, ФИО водителя, увозящего технику со склада.
//CREATE TABLE Book (
//        ID int (15) NOT NULL AUTO_INCREMENT,
//        name varchar (255) NOT NULL,
//        publish_house varchar (255) NOT NULL,
//        data_input datetime NOT NULL,
//        FIO datetime NOT NULL,
//        data_output varchar (255),
//        PRIMARY KEY (ID)
//        ) ENGINE=InnODB DEFAULT CHARSET=UTF8
// сущность которую нужно сохранять в базе данных

//Параметры объекта «сеанс»: ID, Название фильма, Киностудия, Дата и время сеанса, Количество билетов на сеанс.
@Entity

public class Gruz {
    private Long ID;
    private String name_load;
    private String content;
    private String city_from;
    private String city_to;
    private String data_input;
    private String data_output;

    protected Gruz() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName_load() {
        return name_load;
    }

    public void setName_load(String name_load) {
        this.name_load = name_load;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCity_from() {
        return city_from;
    }

    public void setCity_from(String city_from) {
        this.city_from = city_from;
    }

    public String getCity_to() {
        return city_to;
    }

    public void setCity_to(String city_to) {
        this.city_to = city_to;
    }

    public String getData_input() {
        return data_input;
    }

    public void setData_input(String data_input) {
        this.data_input = data_input;
    }

    public String getData_output() {
        return data_output;
    }

    public void setData_output(String data_output) {
        this.data_output = data_output;
    }
}