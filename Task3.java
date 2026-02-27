import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        System.out.println("\nРезультаты операций:");
        System.out.printf("Сумма %d и %d равна %d%n", number1, number2, number1 + number2);
        System.out.printf("Разность %d и %d равна %d%n", number1, number2, number1 - number2);
        System.out.printf("Произведение %d и %d равно %d%n", number1, number2, number1 * number2);
        System.out.printf("Частное %d и %d равно %d%n", number1, number2, number1 / number2);
        System.out.printf("Остаток %d и %d равно %d%n", number1, number2, number1 % number2);
        System.out.printf("Максимум из %d и %d равно %d%n", number1, number2, Math.max(number1, number2));
        scanner.close();
    }
}
