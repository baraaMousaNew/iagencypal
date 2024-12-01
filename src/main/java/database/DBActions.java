package database;

public interface DBActions {

    void delete(String statement);

    void update(String statement);

    String get(String statement, String columnName);
}
