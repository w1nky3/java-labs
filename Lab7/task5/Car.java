package task5;

import java.util.HashSet;
import java.util.Set;

public class Car {
    private String model;
    private String color;
    private int year;

    private static Set<String> availableColors = new HashSet<>();

    static {
        availableColors.add("Red");
        availableColors.add("Blue");
        availableColors.add("Black");
        availableColors.add("White");
        availableColors.add("Silver");
    }

    public Car(String model, String color, int year){
        setModel(model);
        setYear(year);

        if (!availableColors.contains(color)){
            throw new IllegalArgumentException("Цвет недопустим");
        }

        this.color = color;
    }

    public void changeColor(String newColor){
        if (!availableColors.contains(newColor)){
            throw new IllegalArgumentException("Цвет недопустим");
        }

        this.color = newColor;
    }

    public static void addNewColor(String color){
        if (color == null || color.isBlank()){
            throw new IllegalArgumentException("Цвет не может быть пустым");
        }

        availableColors.add(color);
    }

    //геттер и сеттер для model
    public String getModel(){
        return model;
    }

    public void setModel(String model){
        if (model == null || model.isBlank()){
            throw new IllegalArgumentException("Модель не может быть путсой");
        }

        this.model = model;
    }

    //геттер сеттер для year
    public int getYear(){
        return year;
    }

    public void setYear(int year){
        if (year <= 0){
            throw new IllegalArgumentException("Год должен быть положительным");
        }

        this.year = year;
    }

    //геттер для color
    public String getColor(){
        return color;
    }

    public static Set<String> getAvailableColors(){
        return new HashSet<>(availableColors);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}
