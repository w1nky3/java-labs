import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Task9 {
    public static void main(String[] args) {
        String urlString = "https://www.java.com"; 
        String fileName = "java.html";
        
        try ( 
            InputStream in = new URL(urlString).openStream();
            FileOutputStream fos = new FileOutputStream(fileName)
        ) {
           byte[] buffer = new byte[4096];
           int bytesRead;
           
            while ((bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("Страница сохранена в файле: " + fileName);
        } catch (MalformedURLException e) {
            System.out.println("Неверный URL-адрес");

        } catch (IOException e) {
            System.out.println("Ошибка загрузки или сохранения страницы");
        }
    }
}
