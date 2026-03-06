import java.util.Random;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Запрашиваем размер массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        scanner.close();
        
        int[] arr = new int[size];

        //Заполнение массива случайными числами от -50 до 50
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101) - 50;
        }

        //Вывод массива
        System.out.println("Сгенерированный массив:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        int max = arr[0];
        int min = arr[0];
        int maxIndex = 0;
        int minIndex = 0;

        //Поиск максимального и минимального элемента массива
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        //Вывод максимального и минимального элемента массива
        System.out.println("\nМаксимальный элемент массива: " + max);
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Индекс максимального элемента: " + maxIndex);
        System.out.println("Индекс минимального элемента: " + minIndex);
    }
}
