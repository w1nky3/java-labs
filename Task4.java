import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите трехзначное число: ");
        int number = scanner.nextInt();

        System.out.printf("Сумма цифр: %d%n", (number / 100) + ((number / 10) % 10) + (number % 10));
        scanner.close();
    }
}
