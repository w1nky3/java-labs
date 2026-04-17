public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("Clean Code", "Robert Martin", 3);
        Book book3 = new Book(book2);

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println("Всего создано книг: " + Book.getTotalBooks());

        System.out.println("Книга 2 доступна? " + book2.isAvailable());
        book2.borrowCopy();
        book2.borrowCopy();
        System.out.println("После двух выдач: " + book2);

        book2.returnCopy();
        System.out.println("После возврата: " + book2);
    }
}
