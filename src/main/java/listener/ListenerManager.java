package listener;

import database.DBHelper;
import database.MSSQLActions;
import driver_factory.DriverManager;
import io.restassured.http.Method;
import org.testng.*;
import properties.Product;
import rest_assured.PayLoadHelper;
import rest_assured.variables.ApiFilePath;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ListenerManager implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
//        DBHelper dbHelper = new DBHelper();
//        dbHelper.getDB().update(String.format(Product.ProductProps.cancelInProgressForms, Product.ProductProps.brokerUsername));
//        dbHelper.getDB().delete(Product.ProductProps.deleteCreatedClients);
//        dbHelper.getDB().delete(Product.ProductProps.deleteCreatedAgents);
    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //DriverManager.getDriver().quit();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //DriverManager.getDriver().quit();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //DriverManager.getDriver().quit();
    }

    @Override
    public void onTestStart(ITestResult result) {
        //DriverManager.setDriver();
    }

    @Override
    public void onFinish(ISuite suite) {

    }
}
