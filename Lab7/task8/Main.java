package task8;

public class Main {
    public static void main(String[] args) {
        Logger.logInfo("Приложение запущено");
        Logger.logWarning("Мало свободной памяти");
        Logger.logError("Не удалось подключиться к серверу");
        Logger.logInfo("Попытка переподключения");
        Logger.logWarning("Используется резервная конфигурация");

        System.out.println(Logger.getStats());
    }
}
