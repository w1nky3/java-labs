package Task3;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private double interestRate;
    private boolean isActive;

    //Конструктор
    public BankAccount(String accountNumber, String ownerName, double initialBalance, double interestRate){
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);

        if (initialBalance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        }
        this.balance = initialBalance;

        setInterestRate(interestRate);
        setIsActive(true);
    }


    //Геттер и сеттер номера аккаунта
    public String getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber){
        if (accountNumber == null || accountNumber.isBlank()){
            throw new IllegalArgumentException("Ошибка: Номер аккаунта не может быть пустой");
        }

        this.accountNumber = accountNumber;
    }

    //Геттер и сеттер имени владельца
    public String getOwnerName(){
        return ownerName;
    }

    public void setOwnerName(String ownerName){
        if (ownerName == null || ownerName.isBlank()){
            throw new IllegalArgumentException("Ошибка: Имя владельца не может быть пустым");
        }

        this.ownerName = ownerName;
    }

    //Геттер и сеттер баланса
    public double getBalance(){
        return balance;
    }

    //Геттер и сеттер процентной ставки
    public double getInterestRate(){
        return interestRate;
    }

    public void setInterestRate(double interestRate){
        if (interestRate < 0){
            throw new IllegalArgumentException("Ошибка: Процентная ставка не может быть отрицательной");
        }

        this.interestRate = interestRate;
    }

    //Геттер и сеттер для isActive
    public boolean isActive(){
        return isActive;
    }

    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }

    //Метод deposit
    public void deposit(double amount){
        if (amount <= 0){
            throw new IllegalArgumentException("Ошибка: нельзя пополнить отрицательную сумму");
        }

        if (!isActive) {
            throw new IllegalStateException("Счет закрыт");
        }

        balance += amount;
    }

    //Метод withdraw
    public void withdraw(double amount){
        if (amount <= 0 || amount > balance){
            throw new IllegalArgumentException("Ошибка: Вы пытаетесь снять отрицательую сумму или сумму которая больше чем баланс");
        }

        if (!isActive) {
            throw new IllegalStateException("Счет закрыт");
        }

        balance -= amount;
    }

    //Метод transfer
    public void transfer(BankAccount to, double amount){
        withdraw(amount);
        to.deposit(amount);
    }

    //Метод applyInterest
    public void applyInterest(){
        if (!isActive) {
            throw new IllegalStateException("Счет закрыт");
        }
        
        balance += balance * interestRate / 100;
    }

    //Метод closeAccount
    public void closeAccount(){
        setIsActive(false);
    }

    //Метод printInfo
    public void printInfo(){
        System.out.println("Номер счета: " + accountNumber);
        System.out.println("Имя владельца: " + ownerName);
        System.out.printf("Баланс: %.2f%n", balance);
        System.out.println("Процентная ставка: " + interestRate);
        System.out.println("Активен ли счет: " + (isActive ? "Да" : "Нет"));
    }
}
