package Lab2;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Ввод данных
        System.out.print("Введите текущий час: ");
        int hour = scanner.nextInt();
        scanner.close();

        //Проверка на отрицательные значения
        if (hour < 0){
            System.out.println("Не может быть отрицательных значений");
            return;
        }

        if (hour <= 5){
            System.out.println("Ночь");
        } else if (hour <= 11){
            System.out.println("Утро");
        } else if (hour <= 17){
            System.out.println("День");
        } else if (hour <= 23){
            System.out.println("Вечер");
        } else{
            System.out.println("Error: Данные выходят за пределы 0-23");
        }
    }
}
