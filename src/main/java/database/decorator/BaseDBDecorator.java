package database.decorator;

import database.DBActions;

public class BaseDBDecorator implements DBActions {

    private DBActions dbActions;

    protected DBService dbService;

    public BaseDBDecorator(DBActions dbActions, DBService dbService) {
        this.dbActions = dbActions;
        this.dbService = dbService;
    }

    @Override
    public void delete(String statement) {
        this.dbActions.delete(statement);
    }

    @Override
    public void update(String statement) {
        this.dbActions.update(statement);
    }

    @Override
    public String get(String statement, String columnName) {
        return this.dbActions.get(statement, columnName);
    }
}
