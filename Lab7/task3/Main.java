package task3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создаём первый объект:");
        InitializationDemo demo1 = new InitializationDemo();

        System.out.println();

        System.out.println("Создаём второй объект:");
        InitializationDemo demo2 = new InitializationDemo("custom");
    }
}

/*
Вывод:
Создаём первый объект:
Инициализация staticField
Статический блок инициализации
Инициализация instanceField
Нестатический блок инициализации
Конструктор с параметром: default
Конструктор без параметров завершил работу

Создаём второй объект:
Инициализация instanceField
Нестатический блок инициализации
Конструктор с параметром: custom


Порядок такой:
1. При первой загрузке класса выполняются статические инициализации:
    инициализация staticField
    статический блок
2. При создании каждого объекта выполняются:
    инициализация поля экземпляра instanceField
    нестатический блок
    конструктор
Статическая часть выполняется только один раз на класс, 
а нестатическая — при каждом создании объекта.
*/
