package infrastructure.data;

import core.application.common.interfaces.IEmployeeDatabaseContext;

import java.sql.Connection;

public class EmployeeDatabaseContext implements IEmployeeDatabaseContext {
    private Connection dbContextConnection;
    private final String DatabaseContextDriverName;
    private String databaseContextConnectionString;
    private String dbContextUser;
    private String dbContextPassword;

    public EmployeeDatabaseContext() {

        this.DatabaseContextDriverName = "com.mysql.jdbc.Driver";
        this.databaseContextConnectionString = "";
        this.dbContextUser = "root";
        this.dbContextPassword = "1qaz2wsx@";
    }
    @Override
    public Connection databaseContextBuilder() {
        return null;
    }
}
