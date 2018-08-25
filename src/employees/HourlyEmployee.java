package employees;

public class HourlyEmployee extends Employee {

    private double hoursWorkedThisWeek;
    private double hourlyWage;

    public HourlyEmployee(String fullName, String address, String cpf, String paymentMethod, boolean contributesToUnion,
                          int employeeID, double hoursWorkedThisWeek, double hourlyWage) {
        super(fullName, address, cpf, paymentMethod, contributesToUnion, employeeID);
        this.hoursWorkedThisWeek = hoursWorkedThisWeek;
        this.hourlyWage = hourlyWage;
    }

    public double calculateSalary(double hourlyWage, double hoursWorkedThisWeek){
        double temp = hoursWorkedThisWeek;
        hoursWorkedThisWeek = 0;
        if(temp > 40){
            return (hourlyWage * 40) + (hourlyWage * 1.5 * (temp - 40));
        }
        else return hourlyWage * temp;
    }

    public double getHoursWorkedThisWeek() {
        return hoursWorkedThisWeek;
    }

    public void setHoursWorkedThisWeek(double hoursWorkedThisWeek) {
        this.hoursWorkedThisWeek = hoursWorkedThisWeek;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
