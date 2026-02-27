import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите радиус окружности: ");
        double radius = scanner.nextDouble();
        double circleLen = 2 * Math.PI * radius;
        double circleS = Math.PI * Math.pow(radius, 2);

        System.out.printf("Длина окружности с радиусом %.3f: %.3f%n", radius, circleLen);
        System.out.printf("Площадь окружности с радиусом %.3f: %.3f%n", radius, circleS);
        scanner.close();
    }
}
