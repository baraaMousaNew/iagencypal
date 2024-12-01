package database.decorator;

import database.DBActions;
import database.DBHelper;

public class BeforeDBDecorator extends BaseDBDecorator{


    public BeforeDBDecorator(DBActions dbActions, DBService dbService) {
        super(dbActions, dbService);
    }

    @Override
    public void delete(String statement) {
        super.dbService.getMSSQL();
        super.delete(statement);
    }

    @Override
    public String get(String statement, String columnName) {
        super.dbService.getMSSQL();
        return super.get(statement, columnName);
    }

    @Override
    public void update(String statement) {
        super.dbService.getMSSQL();
        super.update(statement);
    }
}
