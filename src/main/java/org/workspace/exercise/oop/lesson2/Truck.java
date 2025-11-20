package org.workspace.exercise.oop.lesson2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Truck extends Vehicle {
    private double tonnage;

    @Override
    public String toString() {
        return "\r\nTruck{\r\t\t" +
                "\"id\":" + getId() +
                "\n\t\t\"manufacturer\":" + getManufacturer() +
                "\n\t\t\"year of manufacturer\":" + getYearOfManufacturer() +
                "\n\t\t\"price\":" + getPrice() +
                "\n\t\t\"color\":" + getColor() +
                "\n\t\t\"tonnage\":" + getTonnage() + "tons" +
                "\r\n}";
    }
}
