import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Запрашиваем ращмер массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        scanner.close();
        
        int[] arr = new int[size];

        //Заполнение массива случайными числами от 0 до 50
        for (int i = 0; i < size; i++){
            arr[i] = random.nextInt(51);
        }

        //Вывод массива и подсчет суммы его элементов
        int sum = 0;
        System.out.println("Сгенерированный массив:");
        for (int num : arr){
            System.out.print(num + " ");
            sum += num;
        }

        //Вывод суммы элементов массива
        System.out.println("\nСумма элементов массива: " + sum);

        //Вывод среднего значения элементов массива
        double average = (double) sum / size;
        System.out.println("Среднее значение элементов массива: " + average);
    }
}
