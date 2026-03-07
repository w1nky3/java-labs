import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.println("Введите слово, которое надо найти:");
        String searchWord = scanner.nextLine();
        scanner.close();

        int lineN = 0;
        int count = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;

            while ((line = br.readLine()) != null){
                lineN++;

                if (line.toLowerCase().contains(searchWord.toLowerCase())){
                    count++;
                    System.out.printf("Строка %d: %s%n", lineN, line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Найдено всего вхождений: " + count);
    }
}
