package infrastructure.services;

import core.application.common.ApplicationConstants;
import core.application.common.interfaces.IEmployeeDatabaseContext;
import core.application.pipeline.XSLTransform;
import core.application.template.EmployeeTemplate;
import core.domain.entities.Employee;
import infrastructure.data.EmployeeDatabaseContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeService extends EmployeeTemplate
{
    private IEmployeeDatabaseContext employeeDatabaseContext;
    private Connection connection = null;

    private static Statement statement;
    private final ArrayList<Employee> employeeList= new ArrayList<Employee>();
    private final Logger logger = Logger.getLogger(EmployeeService.class.getName());

    private static EmployeeService instance = new EmployeeService();

    private PreparedStatement preparedStatement;
    public EmployeeService() {

        this.employeeDatabaseContext = new EmployeeDatabaseContext();
        this.connection = employeeDatabaseContext.databaseContextBuilder();
    }

    /**
     * This method to get instance of this class
     *
     * @return EmployeeService instance
     */

    public static EmployeeService getInstance() {
        return instance;
    }
    @Override
    public void employeeFromXML() {
        try {
            for (Map<String, String> employeeOutputMap : XSLTransform.xmlPaths()) {

                Employee employee = new Employee();

                employee.setEmployeeId(employeeOutputMap.get(ApplicationConstants.XPATH_EMP_ID_KEY));
                employee.setFullName(employeeOutputMap.get(ApplicationConstants.XPATH_EMP_NAME_KEY));
                employee.setAddress(employeeOutputMap.get(ApplicationConstants.XPATH_EMP_ADDRESS_KEY));
                employee.setFacultyName(employeeOutputMap.get(ApplicationConstants.XPATH_EMP_FACULTY_KEY));
                employee.setDepartment(employeeOutputMap.get(ApplicationConstants.XPATH_EMP_DETP_KEY));
                employee.setDesignation(employeeOutputMap.get(ApplicationConstants.XPATH_EMP_DESIGNATION_KEY));

                employeeList.add(employee);

                logger.info(employee.toString() + "\n");

            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE,ex.getMessage());
        }
    }

    @Override
    public void employeeTableCreate() {

    }

    @Override
    public void addEmployee() {

    }

    @Override
    public void employeeById(String employeeId) {

    }

    @Override
    public void employeeDelete(String employeeId) {

    }

    @Override
    public void employeeDisplay() {

    }
}
