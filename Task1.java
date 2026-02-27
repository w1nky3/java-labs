import java.util.Scanner;

public class Task1 {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        System.out.printf("\n Привет %s! Через 5 лет тебе будет %d лет", name, age+5);
        scanner.close();
    }
}
