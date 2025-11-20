package org.workspace.exercise.oop.lesson3;

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
        return "\n╔══════════════ TRUCK ════════════════╗" +
                "\n║ ID: " + getId() +
                "\n║ Manufacturer: " + getManufacturer() +
                "\n║ Year: " + getYearOfManufacturer() +
                "\n║ Price: " + String.format("%,.0f", getPrice()) + " VND" +
                "\n║ Color: " + getColor() +
                "\n║ Tonnage: " + tonnage + " tons" +
                "\n╚════════════════════════════════════╝";
    }
}

