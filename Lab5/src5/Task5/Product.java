package Task5;


public class Product {
    private String name;
    private double price;
    private int quantityInStock;
    private String category;

    //Конструктор
    public Product(String name, double price, int quantityInStock, String category){
        setName(name);
        setPrice(price);
        setQuantityInStock(quantityInStock);
        setCategory(category);
    }

    //Геттер и сеттер для name
    public String getName(){
        return name;
    }

    public void setName(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Ошибка: Имя продукта не может быть пустым");
        }

        this.name = name;
    }

    //Геттер и сеттер для price
    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        if (price < 0){
            throw new IllegalArgumentException("Ошибка: Цена не может быть отрицательной");
        }

        this.price = price;
    }

    //Геттер и сеттер для quantityInStock
    public int getQuantityInStock(){
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock){
        if (quantityInStock < 0){
            throw new IllegalArgumentException("Ошибка: Кол-во товара не может быть отрицательным");
        }

        this.quantityInStock = quantityInStock;
    }

    //Геттер и сеттер для category
    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        if (category == null || category.isBlank()){
            throw new IllegalArgumentException("Ошибка: Категория продукта не может быть пустой");
        }

        this.category = category;
    }


    //Метод isAvailable
    public boolean isAvailable(){
        return quantityInStock > 0;
    }

    //Метод reduceStock
    public void reduceStock(int quantity){
        if (quantity > quantityInStock || quantity <= 0){
            throw new IllegalArgumentException("Ошибка: Кол-во продуктов, должно быть больше 0");
        }
        
        if (quantity > quantityInStock){
            throw new IllegalArgumentException("Ошибка: недостаточно товара на складе");
        }

        quantityInStock -= quantity;
    }

    //Метод printInfo
    public void printInfo(){
        System.out.println("Название продукта: " + name);
        System.out.printf("Цена продукта: %.2f%n", price);
        System.out.println("Кол-во продукта на складе: " + quantityInStock);
        System.out.println("Категория: " + category);
    }
}
