package database.decorator;

import database.DBActions;

public class AfterDBDecorator extends BaseDBDecorator{

    public AfterDBDecorator(DBActions dbActions, DBService dbService) {
        super(dbActions, dbService);
    }

    @Override
    public void delete(String statement) {
        super.delete(statement);
        super.dbService.closeMSSQL();
    }

    @Override
    public String get(String statement, String columnName) {
        String value = super.get(statement, columnName);
        super.dbService.closeMSSQL();
        return value;
    }

    @Override
    public void update(String statement) {
        super.update(statement);
        super.dbService.closeMSSQL();
    }
}
