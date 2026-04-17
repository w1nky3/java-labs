package task10;

public class Parent {
    private static String parentStaticField = initParentStaticField();
    private String parentInstanceField = initParentInstanceField();

    static {
        System.out.println("Parent: static block");
    }

    {
        System.out.println("Parent: instance block");
    }

    public Parent() {
        System.out.println("Parent: constructor");
    }

    private static String initParentStaticField() {
        System.out.println("Parent: static field initialization");
        return "parent static";
    }

    private String initParentInstanceField() {
        System.out.println("Parent: instance field initialization");
        return "parent instance";
    }
}
