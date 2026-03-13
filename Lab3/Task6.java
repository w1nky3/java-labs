import java.io.*;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        
        String fileName = "numbers.txt";

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;

        try (Scanner scanner = new Scanner(new File(fileName))) {

            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                sum += num;
                count++;

                if (num < min) { min = num; }
                if (num > max) { max = num; }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            return;
        }

        if (count == 0){
                System.out.println("Файл не содержит чисел.");
                return;
            }

            double average = (double) sum / count;

            System.out.println("Сумма: " + sum);
            System.out.println("Среднее: " + average);
            System.out.println("Минимум: " + min);
            System.out.println("Максимум: " + max);
    }
}
