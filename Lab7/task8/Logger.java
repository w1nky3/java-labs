package task8;

public class Logger {
    private static int totalMessages;
    private static int errorCount;
    private static int warningCount;

    public static void logInfo(String message){
        validateMessage(message);
        System.out.println("[INFO] " + message);
        totalMessages++;
    }

    public static void logWarning(String message){
        validateMessage(message);
        System.out.println("[WARNING] " + message);
        totalMessages++;
        warningCount++;
    }

    public static void logError(String message){
        validateMessage(message);
        System.out.println("[ERROR] " + message);
        totalMessages++;
        errorCount++;
    }

    public static String getStats(){
        return "Всего сообщений: " + totalMessages +
                ", из них ошибок: " + errorCount +
                ", предупреждений: " + warningCount;
    }

    private static void validateMessage(String message){
        if (message == null || message.isBlank()){
            throw new IllegalArgumentException("Сообщение не может быть пустым");
        }
    }
}
