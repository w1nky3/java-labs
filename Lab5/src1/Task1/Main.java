package Task1;


public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("Война и мир", "Лев Толстой", 1869, 1225, "Эксмо", true),
            new Book("1984", "Джордж Оруэлл", 1949, 328, "АСТ", true),
            new Book("Гарри Поттер и философский камень", "Дж. К. Роулинг", 1997, 432, true)
        };

        System.out.println("Информация о книгах:");
        for (Book book: books){
            book.printInfo();
            System.out.println("Старая ли книга: " + (book.isOld() ? "Да" : "Нет"));
            System.out.println("---------------------------");
        }

        System.out.println("\nПроверка borrow()");
        books[0].borrow();
        books[0].borrow();

        System.out.println("\nПроверка returnBook()");
        books[0].returnBook();
        books[0].returnBook();
    }
}
