package task10;

public class Child extends Parent{
    private static String childStaticField = initChildStaticField();

    private String childInstanceField = initChildInstanceField();

    static {
        System.out.println("Child: static block");
    }

    {
        System.out.println("Child: instance block");
    }

    public Child() {
        System.out.println("Child: constructor");
    }

    private static String initChildStaticField() {
        System.out.println("Child: static field initialization");
        return "child static";
    }

    private String initChildInstanceField() {
        System.out.println("Child: instance field initialization");
        return "child instance";
    }
}   
