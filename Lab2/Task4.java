import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        // Ввод номера месяца
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца (1-12): ");
        int month = scanner.nextInt();
        scanner.close();

        // Определение количества дней в месяце
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31 день");
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30 дней");
                break;

            case 2:
                System.out.println("28 или 29 дней");
                break;

            default:
                System.out.println("Ошибка: некорректный номер месяца");
        }

    }
}
