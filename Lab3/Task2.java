import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исходный файл: ");
        String inputFile = scanner.nextLine();

        System.out.print("Введите целевой файл: ");
        String outputFile = scanner.nextLine();
        scanner.close();

        long stratTime = System.currentTimeMillis();

        try ( BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile));
              BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outputFile)))
        {
            byte[] buffer = new byte[4096];
            int bytesRead;
            long size = 0;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
                size += bytesRead;
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Размер файла: " + size + " байт");
            System.out.println("Время копирования: " + (endTime - stratTime) + " мс");
            System.out.println("Файл успешно скопирован.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
