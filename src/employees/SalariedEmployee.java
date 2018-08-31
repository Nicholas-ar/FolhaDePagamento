package employees;

public class SalariedEmployee extends Employee {

    private double salary;

    public SalariedEmployee(String fullName, String address, String cpf, String paymentMethod, boolean contributesToUnion,
                            int employeeID, double salary) {
        super(fullName, address, cpf, paymentMethod, contributesToUnion, employeeID);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateSalary() {
        double month = this.getMonthlyCosts();
        this.setMonthlyCosts(0);
        return this.salary - month - this.getServiceCosts();
    }
}
