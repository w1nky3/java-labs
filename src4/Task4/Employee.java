package src4.Task4;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String fullName;
    private String position;
    private String department;
    private double salary;
    private LocalDate hireDate;
    private double bonus;

    public Employee(String fullName, String position, String department, double salary, LocalDate hireDate) {
        this(fullName, position, department, salary, hireDate, 0);
    }

    public Employee(String fullName, String position, String department, double salary, LocalDate hireDate, double bonus) {
        setFullName(fullName);
        setPosition(position);
        setDepartment(department);
        setSalary(salary);
        setHireDate(hireDate);
        setBonus(bonus);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Ошибка: ФИО не может быть пустым");
        }
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null || position.isBlank()) {
            throw new IllegalArgumentException("Ошибка: должность не может быть пустой");
        }
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("Ошибка: отдел не может быть пустым");
        }
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Ошибка: зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        if (hireDate == null) {
            throw new IllegalArgumentException("Ошибка: дата приема не может быть null");
        }
        this.hireDate = hireDate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus < 0) {
            throw new IllegalArgumentException("Ошибка: надбавка не может быть отрицательной");
        }
        this.bonus = bonus;
    }

    public double getTotalSalary() {
        return salary + bonus;
    }

    public int getExperience() {
        return Period.between(hireDate, LocalDate.now()).getYears();
    }

    public boolean isEligibleForPromotion() {
        return getExperience() > 3 && salary < 100000;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Отдел: " + department);
        System.out.printf("Зарплата: %.2f%n", salary);
        System.out.printf("Надбавка: %.2f%n", bonus);
        System.out.printf("Общая зарплата: %.2f%n", getTotalSalary());
        System.out.println("Дата приема: " + hireDate);
        System.out.println("Стаж: " + getExperience() + " лет");
        System.out.println("Подходит для повышения: " + (isEligibleForPromotion() ? "Да" : "Нет"));
    }
}
