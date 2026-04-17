package task10;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
    }
}

/*
    Вывод:
    Parent: static field initialization
    Parent: static block
    Child: static field initialization
    Child: static block
    Parent: instance field initialization
    Parent: instance block
    Parent: constructor
    Child: instance field initialization
    Child: instance block
    Child: constructor

    Порядок именно такой, потому что:

    1. Сначала загружается родительский класс Parent:
     инициализируется его static-поле
     выполняется static-блок

    2. Затем загружается дочерний класс Child:
     инициализируется его static-поле
     выполняется static-блок

    3. При создании объекта Child сначала создаётся часть объекта Parent:
     инициализируются поля экземпляра Parent
     выполняется блок инициализации Parent
     выполняется конструктор Parent

    4. После этого инициализируется часть Child:
     инициализируются поля экземпляра Child
     выполняется блок инициализации Child
     выполняется конструктор Child
*/