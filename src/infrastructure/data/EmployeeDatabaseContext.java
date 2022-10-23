package infrastructure.data;

import core.application.common.ApplicationConstants;
import core.application.common.configuration.Configuration;
import core.application.common.interfaces.IEmployeeDatabaseContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class EmployeeDatabaseContext  implements IEmployeeDatabaseContext {
    private Connection databaseContextConnection;
    private final String databaseContextDriverName;
    private String databaseContextConnectionString;
    private String databaseContextUser;
    private String databaseContextPassword;
    private Properties _configuration;

    public EmployeeDatabaseContext() {
        this._configuration = new Properties();
        this.databaseContextDriverName = ApplicationConstants.DATABASE_CONTEXT_DRIVER_NAME;
        this.databaseContextConnectionString = ApplicationConstants.DATABASE_CONTEXT_CONNECTION_STRING;
        this.databaseContextUser = ApplicationConstants.DATABASE_CONTEXT_USERNAME;
        this.databaseContextPassword = ApplicationConstants.DATABASE_CONTEXT_PASSWORD;

    }
    @Override
    public Connection databaseContextBuilder() {
        try{
            Class.forName(Configuration.properties.getProperty(databaseContextDriverName));
            databaseContextConnection = (Connection)DriverManager.getConnection
                    (_configuration.getProperty(databaseContextConnectionString),
                    _configuration.getProperty(databaseContextUser),
                            _configuration.getProperty(databaseContextPassword));
        }catch(Exception ex){

        }
        return databaseContextConnection;
    }
}
