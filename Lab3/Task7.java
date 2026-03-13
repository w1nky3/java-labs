import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Входной файл: ");
        String inputName = scanner.nextLine();

        System.out.print("Выходной файл: ");
        String outputName = scanner.nextLine();

        System.out.print("Сдвиг: ");
        int shift = scanner.nextInt();
        scanner.close();

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputName), StandardCharsets.UTF_8));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputName), StandardCharsets.UTF_8))
        ) {
            int c;

            while ((c = br.read()) != -1){

                char ch = (char) c;

                if (Character.isLetter(ch)){
                    ch = (char) (ch + shift);
                }

                bw.write(ch);
            }
            
            System.out.println("Файл успешно зашифрован");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
