package Task2;
public class Student {
    private String fullName;
    private String groupId;
    private int studentId;
    private int[] grades;
    private boolean hasScholarship;

    public Student(String fullName, String groupId, int studentId, int[] grades) {
        setFullName(fullName);
        setGroupId(groupId);
        setStudentId(studentId);
        setGrades(grades);
        updateScholarshipStatus();
    }

    public Student(String fullName, String groupId, int studentId) {
        this(fullName, groupId, studentId, new int[]{2, 2, 2, 2, 2});
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        if (groupId == null || groupId.isBlank()) {
            throw new IllegalArgumentException("Ошибка: номер группы не может быть пустым");
        }
        this.groupId = groupId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Ошибка: номер студенческого билета должен быть больше 0");
        }
        this.studentId = studentId;
    }

    public int[] getGrades() {
        return grades.clone();
    }

    public void setGrades(int[] grades) {
        if (grades == null || grades.length != 5) {
            throw new IllegalArgumentException("Ошибка: массив оценок должен содержать ровно 5 элементов");
        }

        for (int grade : grades) {
            if (grade < 2 || grade > 5) {
                throw new IllegalArgumentException("Ошибка: оценка должна быть от 2 до 5");
            }
        }

        this.grades = grades.clone();
        updateScholarshipStatus();
    }

    public boolean hasScholarship() {
        return hasScholarship;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public void updateScholarshipStatus() {
        hasScholarship = calculateAverage() >= 4.5;
    }

    public boolean isExcellent() {
        for (int grade : grades) {
            if (grade != 5) {
                return false;
            }
        }
        return true;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Группа: " + groupId);
        System.out.println("Студенческий билет: " + studentId);
        System.out.print("Оценки: ");
        for (int grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
        System.out.printf("Средний балл: %.2f%n", calculateAverage());
        System.out.println("Стипендия: " + (hasScholarship ? "Да" : "Нет"));
        System.out.println("Отличник: " + (isExcellent() ? "Да" : "Нет"));
    }
}
