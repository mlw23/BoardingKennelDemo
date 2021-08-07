package com.tutoring.boardingkennel.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;

/**
 * Describes the dog that is being borded.
 * Has breed, kennel type, name, age, allergies,
 * how much food they need, whether or not they've been fed, and how much they've been fed
 *
 * @author Mikaila Williams
 * @version 1.0
 */

@Entity
public class Dog {

    @Id
    @GeneratedValue
    private long id;
    @NotBlank(message = "This field is required")
    private String breed;
    @Min(value = 1, message = "Dog must be 1 year or older")
    private int age;
    @NotBlank(message = "This field is required")
    private String name;
    private String allergies;
    @Min(value = 1, message = "This field is required")
    private int amountOfFood; //in cups
    private int amountFed; //amount of food given to dog today
    @NotNull(message = "This field is required")
    private boolean isFed;
    @NotNull(message = "This field is required")
    @Enumerated(EnumType.STRING)
    private KennelSize kennelSize;
//    @ManyToOne
//    BoardingFacility facility;

    public Dog(){
        this.allergies = "";
        this.name = "";
        this.breed = "";
        this.kennelSize = KennelSize.SMALL;
    }

    public Dog(String breed, int age, String name, String allergies,
               int amountOfFood, int amountFed, boolean isFed, KennelSize kennelSize){
        this.breed = breed;
        this.age = age;
        this.name = name;
        this.allergies = allergies;
        this.amountOfFood = amountOfFood;
        this.amountFed = amountFed; //amount of food given to dog today
        this.isFed = isFed;
        this.kennelSize = kennelSize;
        this.amountFed = 0;
    }

    /**
     * Prints out the dog's information
     */
    @Override
    public String toString() {
        String info = name + "'s breed is " + breed + "\n" +
        name + "'s age is " + age + "\n";
        if (!allergies.isEmpty()) {
            info += name + "'s allergies are: " + allergies + "\n";
        } else {
            info += name + " does not have any allergies." + "\n";
        }
        if (isFed) {
            info += name + " has been fed " + amountFed + " cups of food." + "\n";
        } else {
            info += name + " is hungry!" + "\n";
        }
        info += name + " is in kennel size " + kennelSize;

        return info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAllergies() {
        return allergies;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }

    public int getAmountFed() {
        return amountFed;
    }

    public boolean getIsFed() {
        return isFed;
    }

    public KennelSize getKennelSize() {
        return kennelSize;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setAmountOfFood(int amountOfFood) {
        this.amountOfFood = amountOfFood;
    }

    public void setAmountFed(int amountFed) {
        this.amountFed = amountFed;
    }

    public void setIsFed(boolean fed) {
        isFed = fed;
    }

    public void setKennelSize(KennelSize kennelSize) {
        this.kennelSize = kennelSize;
    }
}

