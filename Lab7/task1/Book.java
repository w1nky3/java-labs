public class Book {
    private String title;
    private String author;
    private String isbn;
    private int totalCopies;
    private int borrowedCopies;

    private static int totalBooks = 0;

    public Book(String title, String author){
        setTitle(title);
        setAuthor(author);
        this.totalCopies = 1;
        this.borrowedCopies = 0;
        this.isbn = generateISBN();
        totalBooks++;
    }

    public Book(String title, String author, int totalCopies){
        setTitle(title);
        setAuthor(author);
        setTotalCopies(totalCopies);
        this.borrowedCopies = 0;
        this.isbn = generateISBN();
        totalBooks++;
    }

    public Book(Book other){
        if (other == null) {
            throw new IllegalArgumentException("Объект для копирования не может быть null");
        }

        this.title = other.title;
        this.author = other.author;
        this.isbn = other.isbn;
        this.totalCopies = other.totalCopies;
        this.borrowedCopies = other.borrowedCopies;
        totalBooks++;
    }

    public void borrowCopy(){
        if (!isAvailable()){
            throw new IllegalStateException("Нет свободных экземпляров книги");
        }
        borrowedCopies++;
    }

    public boolean isAvailable(){
        return totalCopies - borrowedCopies > 0;
    }

    public void returnCopy(){
        if (borrowedCopies <= 0){
            throw new IllegalStateException("Все книги уже находятся в библиотеке");
        }
        borrowedCopies--;
    }

    public static String generateISBN(){
        return "ISBN-" + (totalBooks + 1); 
    }

    public static int getTotalBooks(){
        return totalBooks;
    }


    // Геттер и сеттер для title
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Название книги не может быть пустым");
        }

        this.title = title;
    }

    // Геттер и сеттер для author
    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException("Имя автора не может быть пустым");
        }

        this.author = author;
    }

    // Геттер и сеттер для totalCopies
    public int getTotalCopies(){
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies){
        if (totalCopies <= 0){
            throw new IllegalArgumentException("Количество экземпляров должно быть больше 0");
        }
        if (totalCopies < borrowedCopies){
            throw new IllegalArgumentException("Общее количество не может быть меньше числа выданных книг");
        }

        this.totalCopies = totalCopies;
    }

    // Геттер для borrowedCopies
    public int getBorrowedCopies() {
        return borrowedCopies;
    }

    // Геттер для isbn
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString(){
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", totalCopies=" + totalCopies +
                ", borrowedCopies=" + borrowedCopies +
                '}';
    }
}
