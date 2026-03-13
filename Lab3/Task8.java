import java.io.*;

public class Task8 {
    public static void main(String[] args) {
        
        // Создание тестового файла
        String fileName = "bigfile.txt";
        int size = 10 * 1024 * 1024; // 10 МБ

        System.out.println("Создание тестового файла...");
        
        try (FileOutputStream fos = new FileOutputStream(fileName)) {

            byte[] data = "Hello, World. Lab3 Task8. Java\n".getBytes(); // превращаем строку в массив байтов
            int written = 0;

            while (written < size) {
                fos.write(data);
                written += data.length;
            }

            System.out.println("Готово (" + written + " байт)");

        } catch (IOException e) {
            e.printStackTrace();
        }


        // Начало замера времени для FileInputStream
        long startTime1 = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream(fileName)){
            while (fis.read() != -1) {
                // Чтение файла
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime1 = System.currentTimeMillis();


        // Начало замера времени для BufferedInputStream
        long startTime2 = System.currentTimeMillis();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
            while (bis.read() != -1) {
                // Чтение файла
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime2 = System.currentTimeMillis();

        // Вывод результатов
        System.out.println("Чтение побайтово (FileInputStream): " + (endTime1 - startTime1) + " мс");
        System.out.println("Чтение с буфером 4096 байт (BufferedInputStream): " + (endTime2 - startTime2) + " мс");
        System.out.println("Вывод: буферизация ускоряет чтение примерно в " + ((endTime1 - startTime1) / (endTime2 - startTime2)) + " раз!");
    }
}
