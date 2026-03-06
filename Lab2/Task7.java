import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ввод числа от 1 до 10
        System.out.print("Введите число от 1-10:");
        int number = scanner.nextInt();
        scanner.close();

        //Проверка на корректность ввода
        if (number < 1 || number > 10) {
            System.out.println("Ошибка: введите число от 1 до 10");
            return;
        }

        //Вывод таблицы умножения для введенного числа
        System.out.println("Таблица умножения для числа " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", number, i, number * i);
        }
    }
}
