package task4;

public class Main {
    public static void main(String[] args) {
        ImmutableRectangle rect1 = new ImmutableRectangle(5, 3);
        ImmutableRectangle rect2 = rect1.withWidth(10);
        ImmutableRectangle rect3 = rect1.withHeight(7);

        System.out.println("Исходный прямоугольник: " + rect1);
        System.out.println("Площадь: " + rect1.getArea());
        System.out.println("Периметр: " + rect1.getPerimeter());

        System.out.println("Новый с другой шириной: " + rect2);
        System.out.println("Новый с другой высотой: " + rect3);

        System.out.println("Проверка, что исходный не изменился: " + rect1);
    }
}
