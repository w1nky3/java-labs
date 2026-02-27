import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите трехзначное число: ");
        int number = scanner.nextInt();
        int firstDigit = number / 100;
        int secondDigit = (number / 10) % 10;
        int thirdDigit = number % 10;

        int reversedNumber = (thirdDigit * 100) + (secondDigit * 10) + firstDigit;
        System.out.printf("Число в обратном порядке: %d%n", reversedNumber);
        scanner.close();
    }
}
