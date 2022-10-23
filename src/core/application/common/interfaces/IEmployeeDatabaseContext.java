package core.application.common.interfaces;

import java.sql.Connection;

public interface IEmployeeDatabaseContext {

    public Connection databaseContextBuilder();
}
