package database;

import database.decorator.AfterDBDecorator;
import database.decorator.BeforeDBDecorator;
import database.decorator.DBService;

public class DBHelper {

    private DBActions dbActions;

    public DBActions getDB(){
        DBService dbService = new DBService();
        this.dbActions = new BeforeDBDecorator(new AfterDBDecorator
                (new MSSQLActions(dbService), dbService), dbService);
        return this.dbActions;
    }
}
