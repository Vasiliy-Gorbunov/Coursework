public class Main {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Ерёменко", "Олег", "Борисович", 1, 50_000);
        employees[1] = new Employee("Ерёменко", "Олег", "Борисович", 2, 40_000);
        employees[2] = new Employee("Ерёменко", "Олег", "Борисович", 3, 60_000);
        employees[3] = new Employee("Ерёменко", "Олег", "Борисович", 4, 70_000);
        getAllEmployees(employees);
        System.out.println(getSumSalary(employees));
        System.out.println(findMinSalary(employees));
        System.out.println(findMaxSalary(employees));
        System.out.println(getAverageSalary(employees));
        getEmployeeNames(employees);
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
        int minSalary = 0;
        while (minSalary == 0) {
            for (Employee employee : employees) {
                if (employee != null) {
                    minSalary = employee.getSalary();
                }
            }
        }
        for (Employee employee : employees) {
            if (employee != null) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                }
            }
        }
        return minSalary;
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
        return maxSalary;
    }

    public static int getAverageSalary(Employee[] employees) {
        int countEmployers = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                countEmployers++;
            }
        }
        double averageSalary = getSumSalary(employees) / countEmployers;
        return (int) averageSalary;
    }

    public static void getEmployeeNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFirstName()+" "+employee.getSecondName()+" "+employee.getLastName());
            }
        }
    }
}