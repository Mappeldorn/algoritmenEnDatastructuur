package com.example.ad.datasource;

public class Car implements Comparable<Car>{
    private String brand;
    private String type;
    private int cylinder;
    private int horsepower;

    public Car(String brand, String type, int cylinder, int horsepower) {
        this.brand = brand;
        this.type = type;
        this.cylinder = cylinder;
        this.horsepower = horsepower;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder (int cylinder) {
        this.cylinder = cylinder;
    }

    @Override
    public int compareTo(Car compareCar) {
        return Integer.compare(this.getHorsepower(), compareCar.horsepower);
    }
}
