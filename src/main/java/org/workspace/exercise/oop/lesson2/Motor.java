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
public class Motor extends Vehicle {
    private int capacity;

    @Override
    public String toString() {
        return "\r\nMotor{\r\t\t" +
                "\"id\":" + getId() +
                "\n\t\t\"manufacturer\":" + getManufacturer() +
                "\n\t\t\"year of manufacturer\":" + getYearOfManufacturer() +
                "\n\t\t\"price\":" + getPrice() +
                "\n\t\t\"color\":" + getColor() +
                "\n\t\t\"capacity\":" + getCapacity() + "cc" +
                "\r\n}";
    }
}
