import java.util.Scanner;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        scanner.close();

        int chars = 0;
        int words = 0;
        int lines = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;

            while ((line = br.readLine()) != null){
                lines++;
                chars += line.length() + 1; // +1 для учета символа новой строки

                String[] split = line.trim().split("\\s+");
                if (!line.trim().isEmpty()){
                    words += split.length;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Кол-во символов в файле: " + chars);
        System.out.println("Кол-во слов в файле: " + words);
        System.out.println("Кол-во строк в файле: " + lines);
    }
}
