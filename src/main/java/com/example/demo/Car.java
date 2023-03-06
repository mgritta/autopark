package com.example.demo;


import jakarta.persistence.Entity; // анотация что класс является сущностбю и относиться к ORM JPA
import jakarta.persistence.GeneratedValue; // автозаполнение айди
import jakarta.persistence.GenerationType; // identity
import jakarta.persistence.Id;

//«машина»: ID, Вид техники (например, мультиварка), Группа техники (например, бытовые
//приборы), Дата ввоза на склад, Дата вывоза со склада, ФИО водителя, увозящего технику со склада.
// CREATE TABLE Technic (
//   ID int (15) NOT NULL AUTO_INCREMENT,
//   type varchar (255) NOT NULL,
//   squad varchar (255) NOT NULL,
//   data_input datetime NOT NULL,
//   data_output datetime NOT NULL,
//   driver varchar (255),
//   PRIMARY KEY (ID)
//                     ) ENGINE=InnODB DEFAULT CHARSET=UTF8
@Entity
public class Car {
    private Long ID;
    private String mark;
    private String release_date;
    private String register_date;
    private String owner;

    protected Car(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRegister_date() {
        return register_date;
    }

    public void setRegister_date(String register_date) {
        this.register_date = register_date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}