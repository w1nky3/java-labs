import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Телефонная книга");
            System.out.println("0 Изменить контакт");
            System.out.println("1 Добавить контакт");
            System.out.println("2 Удалить контакт");
            System.out.println("3 Найти по имени");
            System.out.println("4 Найти по номеру");
            System.out.println("5 Показать все контакты");
            System.out.println("6 Сохранить в файл");
            System.out.println("7 Загрузить из файла");
            System.out.println("8 Выход\n");
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();
            System.out.println();
            switch (choice) {
                case "0":
                    System.out.print("Введите номер телефона контакта, который хотите изменить: ");
                    String editPhoneNum = scanner.nextLine();
                    
                    Contact editSearchContact = phoneBook.findByPhone(editPhoneNum);
                    if (editSearchContact == null) {
                        System.out.println("Контакт не найден!\n");
                        break; 
                    }
                    System.out.print("Введите новое имя (Enter - оставить старое): ");
                    String newName = scanner.nextLine();

                    String newPhoneNumber;
                    while (true){
                        System.out.print("Введите новый номер телефона (Enter - оставить старый): ");
                        newPhoneNumber = scanner.nextLine();

                        if (newPhoneNumber.isBlank()){
                            break;
                        }

                        if (!PhoneNumberValidator.isValid(newPhoneNumber)){
                            System.out.println("Номер введен в неправильном формате,  попробуйте ввести еще раз:");
                            continue;
                        } 

                        if (phoneBook.findByPhone(newPhoneNumber) != null && !newPhoneNumber.equals(editPhoneNum)){
                            System.out.println("Такой номер уже существует, введите другой");
                        } else {
                            break;
                        }
                    }
                    System.out.print("Введите новый email (Enter - оставить старый): ");
                    String newEmail = scanner.nextLine();
                    
                    if (!newName.isBlank()) {
                        editSearchContact.setName(newName);
                    }

                    if (!newPhoneNumber.isBlank()){
                        editSearchContact.setPhoneNumber(newPhoneNumber);
                    }

                    if (!newEmail.isBlank()){
                        editSearchContact.setEmail(newEmail);
                    }

                    System.out.println("Данные контакта изменены!\n");

                    break;

                case "1":
                    Contact newContact = null;

                    while (true){
                        try {
                            System.out.print("Введите имя: ");
                            String name = scanner.nextLine();

                            String phoneNumber;
                            while (true){
                                System.out.print("Введите номер телефона: ");
                                phoneNumber = scanner.nextLine();
                                if (!PhoneNumberValidator.isValid(phoneNumber)){
                                    System.out.println("Номер введен в неправильном формате,  попробуйте ввести еще раз:");
                                } else {
                                    break;
                                }
                            }

                            System.out.print("Введите email: ");
                            String email = scanner.nextLine();

                            newContact = new Contact(name, phoneNumber, email);
                            System.out.println();
                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                            System.out.println("Попробуйте еще раз!\n");
                        }
                    }

                    if (phoneBook.addContact(newContact)){
                        System.out.println("Контакт добавлен!\n");
                    } else {
                        System.out.println("Контакт с таким номером уже существует\n");
                    }
                    break;

                case "2":
                    System.out.print("Введите номер телефона который вы хотите удалить: ");
                    String number = scanner.nextLine();
                    phoneBook.removeContact(number);
                    System.out.println("Контакт удален!\n");
                    break;

                case "3":
                    System.out.print("Введите имя для поиска: ");
                    String name = scanner.nextLine();
                    ArrayList<Contact> numList = phoneBook.findByName(name);
                    if (numList.isEmpty()){
                        System.out.println("Контакты не найдены.\n");
                    } else {
                        System.out.println("Вот контакты по данному имени:");
                        for (Contact el : numList){
                            System.out.println(el);
                        }
                        System.out.println();
                    }
                    break;
                
                case "4":
                    System.out.print("Введите номер телефона для поиска: ");

                    String phoneNum = scanner.nextLine();

                    Contact searchContact = phoneBook.findByPhone(phoneNum);
                    if (searchContact == null){
                        System.out.println("Контакт не был найден");
                    } else {
                        System.out.println("Контакт: " + searchContact);
                    }
                    System.out.println();
                    break;

                 case "5":
                    ArrayList<Contact> allContacts = phoneBook.getAllContacts();

                    if (allContacts.isEmpty()){
                        System.out.println("Ваш список контактов пуст\n");
                    } else {
                        System.out.println("Весь список ваших контактов:");
                        for (Contact el : allContacts){
                            System.out.println(el);
                        }
                        System.out.println();
                    }
                    break;

                case "6":
                    System.out.print("Введите имя для файла: ");
                    String fileName = scanner.nextLine();
                    phoneBook.saveToFile(fileName);
                    System.out.println("Контакты успешно сохранены!");
                    System.out.println();
                    break;
                
                case "7":
                    System.out.print("Введите имя файла: ");
                    String fileLoadName = scanner.nextLine();
                    try {
                        phoneBook.loadFromFile(fileLoadName);
                        System.out.println("Контакты успешно загружены!");
                    } catch (IOException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    System.out.println();
                    break;

                case "8":
                    isRunning = false;
                    System.out.println("До свидания!");
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}
