import java.util.Random;
import java.nio.ByteBuffer;
import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        String fileName = "input.bin";
        Random random = new Random();

        // Ввод чисел в файл
        try (FileOutputStream fos = new FileOutputStream(fileName)){

           for (int i = 0; i < 100; i++){
                int num = random.nextInt(500);

                byte[] bytes = ByteBuffer.allocate(4).putInt(num).array();
                fos.write(bytes);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Вывод чисел в консоль
        try (FileInputStream fis = new FileInputStream(fileName)) {
            
            byte[] buffer = new byte[4];

            while (fis.read(buffer) != -1){
                int num = ByteBuffer.wrap(buffer).getInt();
                System.out.println(num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
