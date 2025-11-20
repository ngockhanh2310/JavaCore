package org.workspace.exercise.oop.lesson3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Vehicle {
    private String id;
    private String manufacturer;
    private int yearOfManufacturer;
    private double price;
    private String color;

    public String getVehicleType() {
        return this.getClass().getSimpleName();
    }
}

