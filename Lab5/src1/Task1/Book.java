package Task1;

import java.time.Year;

public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;
    private String publisher;
    private boolean isAvailable;

    // Конструктор
    public Book(String title, String author, int year, int pages, String publisher, boolean isAvailable){
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setPages(pages);
        setPublisher(publisher);
        this.isAvailable = isAvailable;
    }

    // Конструктор без издательства
    public Book(String title, String author, int year, int pages, boolean isAvailable){
        this(title, author, year, pages, "Неизвестно", isAvailable);
    }

    //Геттер и сеттер для названия
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if (title == null || title.isBlank()){
            throw new IllegalArgumentException("Ошибка: Название книги не может быть пустым");
        }

        this.title = title;
    }

    //Геттер и сеттер для автора
    public String getAutor(){
        return author;
    }

    public void setAuthor(String author){
        if (author == null || author.isBlank()){
            throw new IllegalArgumentException("Ошибка: Имя автора не может быть пустым");
        }

        this.author = author;
    }

    //Геттер и сеттер для года издания
    public int getYear(){
        return year;
    }

    public void setYear(int year){
        if (year < 1450){
            throw new IllegalArgumentException("Ошибка: Год не может быть ниже 1450");
        }

        this.year = year;
    }

    //Геттер и сеттер для кол-ва страниц
    public int getPages(){
        return pages;
    }

    public void setPages(int pages){
        if (pages <= 0){
            throw new IllegalArgumentException("Ошибка: кол-во страниц не может быть меньше 1");
        }

        this.pages = pages;
    }

    //Геттер и сеттер для кол-ва страниц
    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        if (publisher == null || publisher.isBlank()){
            publisher = "Неизвестно";
        }

        this.publisher = publisher;
    }

    //Геттер и сеттер для доступности книги
    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    //Полная информация о книге
    public void printInfo(){
        System.out.println("Название: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Год издания: " + year);
        System.out.println("Кол-во страниц: " + pages);
        System.out.println("Издательство: " + publisher);
        System.out.println("Доступна ли книга: " + (isAvailable ? "Да" : "Нет"));
    }

    //borrow
    public void borrow(){
        if (!isAvailable){
            System.out.println("Книга " + title + " уже взята");
            return;
        }

        isAvailable = false;
        System.out.println("Книгу " + title +" взяли");
    }

    //return book
    public void returnBook(){
        if (isAvailable){
            System.out.println("Книга " + title + " и так уже доступна");
            return;
        }

        isAvailable = true;
        System.out.println("Книга " + title + " возвращена");
    }

    //isOld
    public boolean isOld(){
        int currentYear = Year.now().getValue();

        return (currentYear - year) > 50;
    }
}


