import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.println("Имя файла: " + fileName);

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            System.out.println("Введите строки (пустая строка - завершить):");

            while (true){
                String line = scanner.nextLine();

                if (line.isEmpty()){
                    break;
                }

                bw.write(line);
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
        System.out.printf("Файл %s успешно сохранен", fileName);
    }
}
