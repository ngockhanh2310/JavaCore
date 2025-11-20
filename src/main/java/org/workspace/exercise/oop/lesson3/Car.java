package org.workspace.exercise.oop.lesson3;

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
    private String engine;

    @Override
    public String toString() {
        return "\n╔════════════════ CAR ════════════════╗" +
                "\n║ ID: " + getId() +
                "\n║ Manufacturer: " + getManufacturer() +
                "\n║ Year: " + getYearOfManufacturer() +
                "\n║ Price: " + String.format("%,.0f", getPrice()) + " VND" +
                "\n║ Color: " + getColor() +
                "\n║ Seats: " + seats +
                "\n║ Engine: " + engine +
                "\n╚════════════════════════════════════╝";
    }
}

