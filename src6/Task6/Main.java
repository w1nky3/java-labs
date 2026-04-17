package src6.Task6;

public class Main {
    public static void main(String[] args) {
        Time time1 = new Time(10, 30, 45);
        Time time2 = new Time();
        Time time3 = new Time(23, 59, 50);

        System.out.println("=== Время 1 ===");
        time1.print24h();
        time1.print12h();

        System.out.println("\n=== Текущее системное время ===");
        time2.print24h();
        time2.print12h();

        System.out.println("\n=== Время 3 до изменений ===");
        time3.print24h();

        System.out.println("\n=== Добавляем секунды, минуты, часы ===");
        time3.addSeconds(15);
        time3.print24h();

        time3.addMinutes(2);
        time3.print24h();

        time3.addHours(1);
        time3.print24h();

        System.out.println("\n=== Разница между time1 и time3 ===");
        System.out.println("Разница в секундах: " + time1.differenceInSeconds(time3));

        System.out.println("\n=== Проверка ошибки ===");
        try {
            Time badTime = new Time(25, 10, 10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
