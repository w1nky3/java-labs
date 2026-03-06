import java.util.Random;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Запрашиваем ращмер массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        scanner.close();
        
        int[] arr = new int[size];

        //Заполнение массива случайными числами от -10 до 10
        for (int i = 0; i < size; i++){
            arr[i] = random.nextInt(21) - 10;
        }

        //Вывод массива
        System.out.println("Сгенерированный массив:");
        for (int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();

        //Подсчет количества положительных, отрицательных и нулевых элементов массива
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        for (int num : arr){
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        //Вывод количества положительных, отрицательных и нулевых элементов массива
        System.out.println("Количество положительных элементов: " + positiveCount);
        System.out.println("Количество отрицательных элементов: " + negativeCount);
        System.out.println("Количество нулевых элементов: " + zeroCount);
    }
}
