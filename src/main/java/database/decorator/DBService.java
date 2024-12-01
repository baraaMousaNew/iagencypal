package database.decorator;

import org.testng.Assert;
import properties.Platform;
import properties.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

    private Connection connection;

    protected synchronized Connection getMSSQL(){
        String connectionString = Product.ProductProps.sqlConnection;
        try {
            this.connection = DriverManager.getConnection(connectionString);
        }catch (SQLException e){
            Assert.fail("Cannot connect to db");
        }
        return this.connection;
    }

    protected void closeMSSQL(){
        try {
            this.connection.close();
        }catch (SQLException e){
            Assert.fail("Cannot close db connection");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
