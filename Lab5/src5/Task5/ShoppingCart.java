package Task5;
public class ShoppingCart {
    private Product[] items;
    private int size;

    public ShoppingCart(){
        items = new Product[10];
        size = 0;
    }

    //Метод addProduct
    public void addProduct(Product product, int quantity){
        if (product == null){
            throw new IllegalArgumentException("Товар не может быть null");
        }

        if (size + quantity > items.length){
           throw new IllegalStateException("Корзина переполнена");
        }

        // проверка склада внутри Product
        product.reduceStock(quantity);

        for (int i = 0; i < quantity; i++){
            items[size++] = product;
        }
    }

    //Метод removeProduct
    public void removeProduct(String productName){
        if (productName == null || productName.isBlank()){
            throw new IllegalArgumentException("Ошибка: Имя продукта не может быть пустым");
        }

        for (int i = 0; i < size; i++){
            if (productName.equals(items[i].getName())){
                items[i].setQuantityInStock(items[i].getQuantityInStock() + 1);

                for (int j = i; j < size-1; j++){
                    items[j] = items[j+1];
                }

                items[size-1] = null;
                size--;
                return;
            }
        }
    }

    //Метод getTotalPrice
    public double getTotalPrice(){
        double totalPrice = 0;
        for (int i = 0; i < size; i++){
            totalPrice += items[i].getPrice();
        }

        return totalPrice;
    }

    //Метод checkout
    public void checkout(){
        if (size == 0){
            System.out.println("Корзина пуста");
            return;
        }

        System.out.printf("Заказ оформлен. Общая стоимость: %.2f%n\"", getTotalPrice());

        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
    }

    //Метод printCart
    public void printCart(){
        if (size == 0) {
            System.out.println("Корзина пуста");
            return;
        }

        System.out.println("Содержимое корзины:");

        for (int i = 0; i < size; i++){
            System.out.println((i + 1) + ". " + items[i].getName() + " - " + items[i].getPrice());
        }

        System.out.printf("Общая стоимость: %.2f%n", getTotalPrice());
    }
}
