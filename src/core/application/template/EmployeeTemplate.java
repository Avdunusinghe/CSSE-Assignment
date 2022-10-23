package core.application.template;

public abstract class EmployeeTemplate {
    public abstract void employeeFromXML();
    public abstract void employeeTableCreate();
    public abstract void addEmployee();
    public abstract void employeeById(String employeeId);
    public abstract void employeeDelete(String employeeId);
    public abstract void employeeDisplay();

    //template method
    public final void getEmployeeService(){

        employeeFromXML();

        employeeTableCreate();

        addEmployee();



        employeeDisplay();
    }

}
