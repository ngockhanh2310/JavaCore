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
public class Motor extends Vehicle {
    private int capacity;

    @Override
    public String toString() {
        return "\n╔══════════════ MOTOR ════════════════╗" +
                "\n║ ID: " + getId() +
                "\n║ Manufacturer: " + getManufacturer() +
                "\n║ Year: " + getYearOfManufacturer() +
                "\n║ Price: " + String.format("%,.0f", getPrice()) + " VND" +
                "\n║ Color: " + getColor() +
                "\n║ Capacity: " + capacity + " cc" +
                "\n╚════════════════════════════════════╝";
    }
}

