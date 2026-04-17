package task6;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    private static String url;
    private static String username;
    private static String password;

    static {
        url = "jdbc:h2:mem:test";
        username = "sa";
        password = "";
    }

    private DatabaseConnection(){
    }

    public static DatabaseConnection getInstance(){
        if (instance == null){
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public static void configure(String url, String username, String password){
        if (url == null || url.isBlank()){
            throw new IllegalArgumentException("URL не может быть пустым");
        }

        if (username == null || username.isBlank()){
            throw new IllegalArgumentException("Имя пользователя не может быть пустым");
        }

        if (password == null){
            throw new IllegalArgumentException("Пароль не может быть пустым");
        }

        DatabaseConnection.url = url;
        DatabaseConnection.username = username;
        DatabaseConnection.password = password;
    }

    public void connect(){
        System.out.println("Подключение к БД установленно");
    }

    public void disconnect(){
        System.out.println("Отключено");
    }

    public void executeQuery(String sql){
        System.out.println("Выполнение запроса " + sql);
    }

    public String getUrl(){
        return url;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}

