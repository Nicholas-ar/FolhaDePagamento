package employees;

public class Employee {
    private String fullName;
    private String address;
    private String cpf;
    private String paymentMethod;
    private boolean contributesToUnion;
    private int employeeID;
    private double serviceCosts;
    private double monthlyCosts;

    public Employee(String fullName, String address, String cpf, String paymentMethod, boolean contributesToUnion,
                    int employeeID) {
        this.fullName = fullName;
        this.address = address;
        this.cpf = cpf;
        this.employeeID = employeeID;
        this.paymentMethod = paymentMethod;
        this.contributesToUnion = contributesToUnion;
        this.serviceCosts = 0;
        this.monthlyCosts = 0;
    }

    @Override
    public String toString() {
        return "Full name: " + fullName + '\n' +
                "Address: " + address + '\n' +
                "CPF: " + cpf + '\n' +
                "Employee ID: " + employeeID + '\n' +
                "Payment method: " + paymentMethod + '\n' +
                "Contributes to union: " + contributesToUnion + '\n';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isContributesToUnion() {
        return contributesToUnion;
    }

    public void setContributesToUnion(boolean contributesToUnion) {
        this.contributesToUnion = contributesToUnion;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public double getServiceCosts() {
        return serviceCosts;
    }

    public void setServiceCosts(double serviceCosts) {
        this.serviceCosts = serviceCosts;
    }

    public void addServiceCost(double cost) {
        this.serviceCosts = this.serviceCosts + cost;

    }

    public double getMonthlyCosts() {
        return monthlyCosts;
    }

    public void setMonthlyCosts(double monthlyCosts) {
        this.monthlyCosts = monthlyCosts;
    }
}
