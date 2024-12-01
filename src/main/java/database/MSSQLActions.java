package database;

import database.decorator.DBService;
import org.testng.Assert;

import java.sql.SQLException;
import java.sql.Statement;

public class MSSQLActions implements DBActions{


    private DBService dbService;

    public MSSQLActions(DBService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void delete(String statement) {
        Statement statement1 = null;
        try {
            statement1 = dbService.getConnection().createStatement();
            statement1.executeQuery(statement);
        }catch (SQLException e){
            if(!e.getMessage().equals("The statement did not return a result set.")){
                Assert.fail("Fails to execute sql statement: " + e);
            }
        }
    }

    @Override
    public void update(String statement) {
        Statement statement1 = null;
        try {
            statement1 = dbService.getConnection().createStatement();
            statement1.executeQuery(statement);
        }catch (SQLException e){
            if(!e.getMessage().equals("The statement did not return a result set.")){
                Assert.fail("Fails to execute sql statement: " + e);
            }
        }
    }

    @Override
    public String get(String statement, String columnName) {
        Statement statement1;
        try {
            statement1 = dbService.getConnection().createStatement();
            return statement1.executeQuery(statement).getNString(columnName);
        }catch (SQLException e){
            Assert.fail("Fails to execute sql statement: " + e);
        }
        return null;
    }
}
