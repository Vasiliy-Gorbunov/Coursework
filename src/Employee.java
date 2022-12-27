public class Employee {
    private String firstName;
    private String secondName;
    private String lastName;
    private int department;
    private int salary;
    private static int counter;
    private final int id;



    public Employee(String firstName, String secondName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        counter++;
        this.id = counter;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Сотрудник " + id + "\n " +
                "ФИО: " + firstName + " " + secondName + " " + lastName + "\n " +
                "Отдел: " + department + "\n " +
                "Зарплата: " + salary;
    }
}
