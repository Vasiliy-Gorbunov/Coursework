public class Main {
    private static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Аверкиева", "Алёна", "Александровна", 1, 50_000);
        employees[1] = new Employee("Бегунов", "Борис", "Борисович", 2, 60_000);
        employees[2] = new Employee("Веретенко", "Владимир", "Васильевич", 3, 70_000);
        employees[3] = new Employee("Гоман", "Галина", "Георгиевна", 4, 80_000);
        employees[4] = new Employee("Деревянко", "Даниил", "Дмитриевич", 5, 90_761);
        employees[5] = new Employee("Ерёменко", "Екатерина", "Егоровна", 1, 45_000);
        employees[6] = new Employee("Жукова", "Жанна", "Жоржевна", 2, 55_000);
        employees[7] = new Employee("Змейко", "Зинаида", "Захаровна", 3, 65_000);
        employees[8] = new Employee("Игнатов", "Игорь", "Иванович", 4, 75_000);
        employees[9] = new Employee("Клименко", "Клара", "Константиновна", 5, 85_346);
        //printAllEmployees();
        //System.out.println(getSumSalary());
        //System.out.println(findMinSalaryEmployee());
        //System.out.println(findMaxSalaryEmployee());
        //System.out.println(getAverageSalary());
        //printEmployeeNames();
        //indexSalary(-20);
        //printAllEmployees();
        //findMinSalaryEmployeeInDepartment(5);
        //findMaxSalaryEmployeeInDepartment(4);
        //System.out.println(getSumSalaryInDepartment(5));
        //System.out.println(getAverageSalaryInDepartment(5));
        //indexSalaryInDepartment(5, 10);
        //printEmployeesInDepartment(5);
        //printEmployeesWithLowerSalary(70000);
        //printEmployeesWithHigherSalary(65000);

    }

    public static void printAllEmployees() {
        for (Employee id : employees) {
            System.out.println(id);
        }
    }

    public static int getSumSalary() {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static Employee checkAvailableEmployee() {
        Employee employee = null;
        for (int i = 0; i < employees.length && employee == null; i++) {
            if (employees[i] != null) {
                employee = employees[i];
            }
        }
        if (employee == null) {
            throw new RuntimeException("Нет ни одного сотрудника!");
        } else {
            return employee;
        }
    }

    public static Employee findMinSalaryEmployee() {
        Employee minSalaryEmployee = checkAvailableEmployee();
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalaryEmployee.getSalary() > employee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        return minSalaryEmployee;

    }

    public static Employee findMaxSalaryEmployee() {
        Employee maxSalaryEmployee = checkAvailableEmployee();
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalaryEmployee.getSalary() < employee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;

    }

    public static double getAverageSalary() {
        int countEmployers = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                countEmployers++;
            }
        }
        if (countEmployers == 0) {
            throw new RuntimeException("Нет ни одного сотрудника!");
        } else {
            return (double) getSumSalary() / countEmployers;
        }
    }

    public static void printEmployeeNames() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFirstName() + " " + employee.getSecondName() + " " + employee.getLastName());
            }
        }
    }

    public static void indexSalary(int index) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (100 + index) / 100);
            }
        }
    }

    public static Employee checkAvailableEmployeeInDepartment(int department) {
        Employee employee = null;
        for (int i = 0; i < employees.length && employee == null; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employee = employees[i];
            }
        }
        if (employee == null) {
            throw new RuntimeException("Нет ни одного сотрудника в этом отделе!");
        } else {
            return employee;
        }
    }

    public static void findMinSalaryEmployeeInDepartment(int department) {
        Employee minSalaryEmployee = checkAvailableEmployeeInDepartment(department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (minSalaryEmployee.getSalary() > employee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
        }
        System.out.println(minSalaryEmployee);
    }

    public static void findMaxSalaryEmployeeInDepartment(int department) {
        Employee maxSalaryEmployee = checkAvailableEmployeeInDepartment(department);
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (maxSalaryEmployee.getSalary() < employee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        System.out.println(maxSalaryEmployee);
    }

    public static int getSumSalaryInDepartment(int department) {
        int sum = 0;
        for (Employee employee : Main.employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static double getAverageSalaryInDepartment(int department) {
        int countEmployers = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                countEmployers++;
            }
        }
        if (countEmployers == 0) {
            throw new RuntimeException("В этом отделе нет ни одного сотрудника!");
        } else {
            return (double) getSumSalaryInDepartment(department) / countEmployers;
        }
    }

    public static void indexSalaryInDepartment(int department, int index) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * (100 + index) / 100);
            }
        }
    }

    public static void printEmployeesInDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println(
                        "Сотрудник №" + employee.getId() + ":\n " +
                                "ФИО: " + employee.getFirstName() + " " + employee.getSecondName() + " " + employee.getLastName() + "\n " +
                                "Зарплата: " + employee.getSalary() + "\n" +
                                employee.separator());
            }
        }
    }

    public static void printEmployeesWithLowerSalary(int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("Сотрудник №" + employee.getId() + ":\n " +
                        "ФИО: " + employee.getFirstName() + " " + employee.getSecondName() + " " + employee.getLastName() + "\n " +
                        "Зарплата: " + employee.getSalary() + "\n" +
                        employee.separator());
            }
        }
    }

    public static void printEmployeesWithHigherSalary(int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("Сотрудник №" + employee.getId() + ":\n " +
                        "ФИО: " + employee.getFirstName() + " " + employee.getSecondName() + " " + employee.getLastName() + "\n " +
                        "Зарплата: " + employee.getSalary() + "\n" +
                        employee.separator());
            }
        }
    }
}