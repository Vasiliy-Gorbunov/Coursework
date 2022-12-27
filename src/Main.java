public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Аверкиева", "Алёна", "Александровна", 1, 50_000);
        employees[1] = new Employee("Бегунов", "Борис", "Борисович", 2, 60_000);
        employees[2] = new Employee("Веретенко", "Владимир", "Васильевич", 3, 70_000);
        employees[3] = new Employee("Гоман", "Галина", "Георгиевна", 4, 80_000);
        employees[4] = new Employee("Деревянко", "Даниил", "Дмитриевич", 5, 90_000);
        employees[5] = new Employee("Ерёменко", "Екатерина", "Егоровна", 1, 45_000);
        employees[6] = new Employee("Жукова", "Жанна", "Жоржевна", 2, 55_000);
        employees[7] = new Employee("Змейко", "Зинаида", "Захаровна", 3, 65_000);
        employees[8] = new Employee("Игнатов", "Игорь", "Иванович", 4, 75_000);
        employees[9] = new Employee("Клименко", "Клара", "Константиновна", 5, 85_000);
        //getAllEmployees(employees);
        //System.out.println(getSumSalary(employees));
        //System.out.println(findMinSalary(employees));
        //System.out.println(findMaxSalary(employees));
        //System.out.println(getAverageSalary(employees));
        //getEmployeeNames(employees);
        //indexSalary(employees, -20);
        //getAllEmployees(employees);
        //minSalaryInDepartment(employees, 5);
        //maxSalaryInDepartment(employees, 4);
        //System.out.println(getSumSalaryInDepartment(employees, 2));
        //System.out.println(getAverageSalaryInDepartment(employees, 3));
        //indexSalaryInDepartment(employees, 5, 10);
        //printEmployeesInDepartment(employees, 5);
        //printEmployeesWithLowerSalary(employees, 70000);
        //printEmployeesWithHigherSalary(employees, 65000);

    }

    public static void getAllEmployees(Employee[] employees) {
        for (Employee id : employees) {
            System.out.println(id);
        }
    }

    public static int getSumSalary(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static int findMinSalary(Employee[] employees) {
        int minSalary = -1;
        for (int i = 0; i < employees.length && minSalary == -1; i++) {
            if (employees[i] != null) {
                minSalary = employees[i].getSalary();
            }
        }
        if (minSalary == -1) {
            throw new RuntimeException("Нет ни одного сотрудника с зарплатой!");
        } else {
            for (Employee employee : employees) {
                if (employee != null) {
                    if (minSalary > employee.getSalary()) {
                        minSalary = employee.getSalary();
                    }
                }
            }
            return minSalary;
        }
    }

    public static int findMaxSalary(Employee[] employees) {
        int maxSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if (maxSalary < employee.getSalary()) {
                    maxSalary = employee.getSalary();
                }
            }
        }
        if (maxSalary == 0) {
            throw new RuntimeException("Нет ни одного сотрудника с зарплатой!");
        } else {
            return maxSalary;
        }
    }

    public static int getAverageSalary(Employee[] employees) {
        int countEmployers = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                countEmployers++;
            }
        }
        if (countEmployers == 0) {
            throw new RuntimeException("Нет ни одного сотрудника!");
        } else {
            double averageSalary = getSumSalary(employees) / countEmployers;
            return (int) averageSalary;
        }
    }

    public static void printEmployeeNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFirstName() + " " + employee.getSecondName() + " " + employee.getLastName());
            }
        }
    }

    public static void indexSalary(Employee[] employees, int index) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * (100 + index) / 100);
            }
        }
    }

    public static void findMinSalaryInDepartment(Employee[] employees, int department) {
        Employee[] minSalaryEmployee = new Employee[1];
        for (int i = 0; i < employees.length && minSalaryEmployee[0] == null; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                minSalaryEmployee[0] = employees[i];
            }
        }
        if (minSalaryEmployee[0] == null) {
            throw new RuntimeException("Нет сотрудников в этом отделе!");
        } else {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    if (minSalaryEmployee[0].getSalary() > employee.getSalary()) {
                        minSalaryEmployee[0] = employee;
                    }
                }
            }
            System.out.println(minSalaryEmployee[0]);
        }
    }

    public static void findMaxSalaryInDepartment(Employee[] employees, int department) {
        Employee[] maxSalaryEmployee = new Employee[1];
        for (int i = 0; i < employees.length && maxSalaryEmployee[0] == null; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                maxSalaryEmployee[0] = employees[i];
            }
        }
        if (maxSalaryEmployee[0] == null) {
            throw new RuntimeException("Нет сотрудников в этом отделе!");
        } else {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    if (maxSalaryEmployee[0].getSalary() < employee.getSalary()) {
                        maxSalaryEmployee[0] = employee;
                    }
                }
            }
            System.out.println(maxSalaryEmployee[0]);
        }
    }

    public static int getSumSalaryInDepartment(Employee[] employees, int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public static int getAverageSalaryInDepartment(Employee[] employees, int department) {
        int countEmployers = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                countEmployers++;
            }
        }
        if (countEmployers == 0) {
            throw new RuntimeException("В этом отделе нет ни одного сотрудника!");
        } else {
            double averageSalaryInDepartment = getSumSalaryInDepartment(employees, department) / countEmployers;
            return (int) averageSalaryInDepartment;
        }
    }

    public static void indexSalaryInDepartment(Employee[] employees, int department, int index) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * (100 + index) / 100);
            }
        }
    }

    public static void printEmployeesInDepartment(Employee[] employees, int department) {
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

    public static void printEmployeesWithLowerSalary(Employee[] employees, int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("Сотрудник №" + employee.getId() + ":\n " +
                        "ФИО: " + employee.getFirstName() + " " + employee.getSecondName() + " " + employee.getLastName() + "\n " +
                        "Зарплата: " + employee.getSalary() + "\n" +
                        employee.separator());
            }
        }
    }

    public static void printEmployeesWithHigherSalary(Employee[] employees, int salary) {
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