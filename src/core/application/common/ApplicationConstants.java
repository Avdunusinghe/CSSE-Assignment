package core.application.common;

import java.text.MessageFormat;

/*
 * this common constant file use for XML based application
 * */
public class ApplicationConstants {
    /** constant for query path Employee ID of XpathEmployeeIDKey */
    public static final String XPATH_EMP_ID_KEY = "XpathEmployeeIDKey";

    /** constant for query path Employee Name of XpathEmployeeNameKey */
    public static final String XPATH_EMP_NAME_KEY = "XpathEmployeeNameKey";

    /** constant for query path Employee Address of XpathEmployeeAddressKey */
    public static final String XPATH_EMP_ADDRESS_KEY = "XpathEmployeeAddressKey";

    /** constant for query path Employee Faculty of XpathFacultyNameKey */
    public static final String XPATH_EMP_FACULTY_KEY = "XpathFacultyNameKey";

    /** constant for query path Employee Department of XpathDepartmentKey */
    public static final String XPATH_EMP_DETP_KEY = "XpathDepartmentKey";

    /** constant for query path Employee Designation of XpathDesignationKey */
    public static final String XPATH_EMP_DESIGNATION_KEY = "XpathDesignationKey";

    /** constant for file path of config.properties */
    public static final String PROPERTY_FILE = "./infrastructure/config/config.properties";

    /** constant for query tag in EmployeeQuery.xml */
    public static final String TAG_NAME = "query";

    /** constant for query id in EmployeeQuery.xml */
    public static final String ATTRIBUTE_ID = "id";

    /** constant for file path of QUERY_FILE */
    public static final String QUERY_FILE_PATH = "QUERY_FILE";

    /** constant for file path of RESPONSE_XML_PATH */
    public static final String RESPONSE_XML_PATH = "RESPONSE_XML_PATH";

    /** constant for file path of MODIFIED_XSL_PATH */
    public static final String MODIFIED_XSL_PATH = "MODIFIED_XSL_PATH";

    /** constant for file path of REQUEST_XML_PATH */
    public static final String REQUEST_XML_PATH = "REQUEST_XML_PATH";

    /** constant for driver name key of MySQL database in config.properties */
    public static final String DATABASE_CONTEXT_DRIVER_NAME = "driverName";

    /** constant for user name key of MySQL database in config.properties */
    public static final String DATABASE_CONTEXT_USERNAME = "username";

    /** constant for URL key of mySQL database in config.properties */
    public static final String DATABASE_CONTEXT_CONNECTION_STRING = "url";

    /** constant for password key of MySQL database in config.properties */
    public static final String DATABASE_CONTEXT_PASSWORD = "password";

    /** constant for Query id one */
    public static final String QUERY_ONE = "q1";

    /** constant for Query id two */
    public static final String QUERY_TWO = "q2";

    /** constant for Query id three */
    public static final String QUERY_THREE = "q3";

    /** constant for Query id four */
    public static final String QUERY_FOUR = "q4";

    /** constant for Query id five */
    public static final String QUERY_FIVE = "q5";

    /** constant for Query id six */
    public static final String QUERY_SIX = "q6";

    /** constant for Column index one */
    public static final int COLUMN_INDEX_ONE = 1;

    /** constant for Column index two */
    public static final int COLUMN_INDEX_TWO = 2;

    /** constant for Column index three */
    public static final int COLUMN_INDEX_THREE = 3;

    /** constant for Column index four */
    public static final int COLUMN_INDEX_FOUR = 4;

    /** constant for Column index five */
    public static final int COLUMN_INDEX_FIVE = 5;

    /** constant for Column index six */
    public static final int COLUMN_INDEX_SIX = 6;

    /** constant for Column index seven */
    public static final int COLUMN_INDEX_SEVEN = 7;

    public static class TransformUtil{

        public static final String BASE_PATH = "//Employees/Employee[";

        public static final String SUB_PATH_EMP_ID ="]/EmployeeID/text()";
        public static final String SUB_PATH_EMP_FULL_NAME ="]/EmployeeFullName/text()";
        public static final String SUB_PATH_EMP_ADDRESS ="]/EmployeeFullAddress/text()";
        public static final String SUB_PATH_EMP_FACULTY_NAME ="]/FacultyName/text()";
        public static final String SUB_PATH_EMP_DEPARTMENT ="]/Department/text()";
        public static final String SUB_PATH_EMP_DESIGNATION ="]/Designation/text()";

        public static final String XPATH_EMPLOYEE_ID = "XpathEmployeeIDKey";
        public static final String XPATH_EMPLOYEE_NAME = "XpathEmployeeNameKey";
        public static final String XPATH_EMPLOYEE_ADDRESS = "XpathEmployeeAddressKey";
        public static final String XPATH_EMPLOYEE_FACULTY = "XpathFacultyNameKey";
        public static final String XPATH_EMPLOYEE_DEPARTMENT = "XpathDepartmentKey";
        public static final String XPATH_EMPLOYEE_DESIGNATION = "XpathDesignationKey";

        public static final String EMPLOYEE_REQUEST_PATH_STRING  = "/infrastructure/data/configuration/EmployeeResponse.xmlEmployeeRequest.xml";
        public static final String EMPLOYEE_MODIFIED_PATH_STRING = "/infrastructure/data/configuration/Employee-modified.xsl";
        public static final String EMPLOYEE_RESPONSE_PATH_STRING = "/infrastructure/data/configuration/EmployeeResponse.xml";

        public static final String COUNTER_PATH = "count(//Employees/Employee)";

        /*
         *
         * This method concatenate,String for compile path
         *
         * */

        public static String getCompliePath(int number,String path2) {
            String message = MessageFormat.format("{0}" + "{1}"+ "{2}",BASE_PATH, number, path2);
            return message;
        }
    }
}
