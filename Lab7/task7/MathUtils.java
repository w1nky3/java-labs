package task7;

public class MathUtils {
    public static final double PI = Math.PI;
    public static final double E = Math.E;

    private MathUtils(){
        throw new UnsupportedOperationException("Нельзя создать объект утилитарного класса");
    }

    /**
     * Проверка числа на простоту
     * 
     * @param n число для проверки
     * @return true, если число простое, иначе false
     */
    public static boolean isPrime(int n){
        if (n < 2){
            return false;
        }

        for (int i = 2; i * i <= n; i++){
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }

    /**
     * Вычисляет наибольший общий делитель двух чисел.
     * 
     * @param a первое число 
     * @param b второе число 
     * @return НОД чисел a и b
     */
    public static int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);

        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    /**
     * Вычисляет наименьшее общее кратное двух чисел
     * 
     * @param a првое число 
     * @param b второе число
     * @return НОК чисел a и b
     */
    public static int lcm(int a, int b){
        if (a == 0 || b == 0){
            return 0;
        }

        return Math.abs(a / gcd(a, b) * b);
    }

    /**
     * Вычисляет факториал числа
     * 
     * @param n число, для которого вычисляется факториал
     * @return факториал числа n
     * @throws IllegalArgumentException если n < 0
     * @throws ArithmeticException если произошло переполнение long
     */
    public static long factorial(int n){
        if (n < 0){
            throw new IllegalArgumentException("Факториал определён только для n >= 0");
        }

        long result = 1;
        for (int i = 2; i <= n; i++){
            if (Long.MAX_VALUE / result < i){
                throw new ArithmeticException("Переполнение при выислении");
            }

            result *= i;
        }

        return result;
    }

    /**
     * Возвращает n-ое число фибоначчи
     * 
     * @param n индекс числа Фибоначчи, n >= 0
     * @return n-е число Фибоначчи
     * @throws IllegalArgumentException если n < 0
     * @throws ArithmeticException если произошло переполнение int
     */
    public static int fibonacci(int n){
        if (n < 0){
           throw new IllegalArgumentException("n должно быть >= 0");  
        }

        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++){
            if (Integer.MAX_VALUE - b < a) {
                throw new ArithmeticException("Переполнение при вычислении fibonacci");
            }

            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}
