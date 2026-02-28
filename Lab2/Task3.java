package Lab2;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ввод данных
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите операцию (+, -, *, /): ");
        String op = scanner.nextLine();
        scanner.close();

        //Основная логика
        switch (op) {
            case "+":
                System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
                break;
            case "-":
                System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
                break;
            case "*":
                System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
                break;
            case "/":
                if (num2 == 0) { System.out.println("Ошибка: деление на ноль");}
                System.out.printf("%d / %d = %d", num1, num2, num1 / num2);
                break;
            default:
                break;
        }
    }
    
}
