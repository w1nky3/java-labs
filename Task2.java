import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите градусы в Цельсиях: ");
        double celsius = scanner.nextDouble();
        double F = (celsius * 9/5) + 32;
        double K = celsius + 273.15;
        System.out.printf("Градусы в Фаренгейтах: %.2f%n", F);
        System.out.printf("Градусы в Кельвинах: %.2f%n", K);
        scanner.close();
    }
}
