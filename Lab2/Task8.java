import java.util.Random;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите размер квадратной матрицы: ");
        int n = scanner.nextInt();
        scanner.close();

        int[][] matrix = new int[n][n];

        // Заполнение матрицы случайными числами от 0 до 9
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        // Вывод матрицы
        System.out.println("Матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

        // Сумма первой строки
        int referenceSum = 0;
        for (int j = 0; j < n; j++) {
            referenceSum += matrix[0][j];
        }

        boolean isMagic = true;

        // Проверка сумм строк
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != referenceSum) {
                isMagic = false;
                break;
            }
        }

        // Проверка сумм столбцов
        if (isMagic) {
            for (int j = 0; j < n; j++) {
                int colSum = 0;
                for (int i = 0; i < n; i++) {
                    colSum += matrix[i][j];
                }
                if (colSum != referenceSum) {
                    isMagic = false;
                    break;
                }
            }
        }

        // Проверка главной диагонали
        if (isMagic) {
            int mainDiagonalSum = 0;
            for (int i = 0; i < n; i++) {
                mainDiagonalSum += matrix[i][i];
            }
            if (mainDiagonalSum != referenceSum) {
                isMagic = false;
            }
        }

        // Проверка побочной диагонали
        if (isMagic) {
            int secondaryDiagonalSum = 0;
            for (int i = 0; i < n; i++) {
                secondaryDiagonalSum += matrix[i][n - 1 - i];
            }
            if (secondaryDiagonalSum != referenceSum) {
                isMagic = false;
            }
        }

        // Результат
        if (isMagic) {
            System.out.println("Да, это магический квадрат");
        } else {
            System.out.println("Нет, это не магический квадрат");
        }
    }
}