package task5;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota Camry", "Black", 2020);
        System.out.println(car1);

        try {
            Car car2 = new Car("BMW X5", "Green", 2022);
            System.out.println(car2);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании автомобиля: " + e.getMessage());
        }

        Car.addNewColor("Green");
        Car car3 = new Car("BMW X5", "Green", 2022);
        System.out.println(car3);

        car1.changeColor("Red");
        System.out.println("После смены цвета: " + car1);

        System.out.println("Доступные цвета: " + Car.getAvailableColors());
    }
}
