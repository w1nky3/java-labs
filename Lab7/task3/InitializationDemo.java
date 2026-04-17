package task3;

public class InitializationDemo {
    private static String staticField = initStaticField();

    private String instanceField = initInstanceField();

    static{
        System.out.println("Статический блок инициализации");
    }

    {
        System.out.println("Нестатический блок инициализации");
    }

    public InitializationDemo(){
        this("default");
        System.out.println("Конструктор без параметров завершил работу");
    }

    public InitializationDemo(String name){
        System.out.println("Конструктор с параметром: " + name);
    }

    private static String initStaticField(){
        System.out.println("Инициализация staticField");
        return "static";
    }

    private String initInstanceField(){
        System.out.println("Инициализация instanceField");
        return "instance";
    }
}
