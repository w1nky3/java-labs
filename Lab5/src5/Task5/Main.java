package Task5;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Хлеб", 1.50, 10, "Еда");
        Product product2 = new Product("Молоко", 2.20, 8, "Напитки");
        Product product3 = new Product("Шоколад", 3.10, 5, "Сладости");

        ShoppingCart cart = new ShoppingCart();

        System.out.println("=== Товары до добавления в корзину ===");
        product1.printInfo();
        System.out.println();
        product2.printInfo();
        System.out.println();
        product3.printInfo();

        System.out.println("\n=== Добавляем товары в корзину ===");
        cart.addProduct(product1, 2);
        cart.addProduct(product2, 3);
        cart.addProduct(product3, 1);

        System.out.println("\n=== Содержимое корзины ===");
        cart.printCart();

        System.out.println("\n=== Остатки на складе после добавления ===");
        product1.printInfo();
        System.out.println();
        product2.printInfo();
        System.out.println();
        product3.printInfo();

        System.out.println("\n=== Удаляем один товар по имени ===");
        cart.removeProduct("Молоко");
        cart.printCart();

        System.out.println("\n=== Остатки на складе после удаления ===");
        product1.printInfo();
        System.out.println();
        product2.printInfo();
        System.out.println();
        product3.printInfo();

        System.out.println("\n=== Оформляем заказ ===");
        cart.checkout();

        System.out.println("\n=== Корзина после оформления ===");
        cart.printCart();

        System.out.println("\n=== Финальные остатки на складе ===");
        product1.printInfo();
        System.out.println();
        product2.printInfo();
        System.out.println();
        product3.printInfo();

        System.out.println("\n=== Проверка ошибок ===");
        try {
            cart.addProduct(product1, 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            cart.removeProduct("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
