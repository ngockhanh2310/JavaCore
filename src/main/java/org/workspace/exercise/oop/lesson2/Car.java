package org.workspace.exercise.oop.lesson2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Car extends Vehicle {
    private int seats;
    private String engine; // động cơ

    @Override
    public String toString() {
        return "\r\nCar{\r\t\t" +
                "\"id\":" + getId() +
                "\n\t\t\"manufacturer\":" + getManufacturer() +
                "\n\t\t\"year of manufacturer\":" + getYearOfManufacturer() +
                "\n\t\t\"price\":" + getPrice() +
                "\n\t\t\"color\":" + getColor() +
                "\n\t\t\"seats\":" + getSeats() +
                "\n\t\t\"engine\":" + getEngine() +
                "\r\n}";
    }
}
