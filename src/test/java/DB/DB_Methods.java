package DB;

import java.sql.*;

public class DB_Methods {

    public boolean isTableExists(String schema, String tableName, Connection connection) throws SQLException {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT EXISTS (\n" +
                    "    SELECT 1\n" +
                    "    FROM information_schema.tables\n" +
                    "    WHERE table_schema = '" + schema + "' -- Replace 'public' with your schema name if different\n" +
                    "    AND table_name = '" + tableName + "'\n" +
                    ");");
            resultSet.next();
            return resultSet.getBoolean(1);
        }
    }

    public boolean checkColumnType(String schema, String tableName,String columnName, String type, Connection connection) throws SQLException {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT data_type\n" +
                    "    FROM information_schema.columns\n" +
                    "    WHERE table_schema = '" + schema + "' AND table_name = '" + tableName + "' AND column_name = '" + columnName + "';");
            resultSet.next();
            return type.equals(resultSet.getString(1));
        }
    }

    public boolean checkColumnRestriction(String schema, String tableName,String columnName, String type, Connection connection) throws SQLException {
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT\n" +
                    "    tc.constraint_name,\n" +
                    "    tc.constraint_type,\n" +
                    "    kcu.column_name\n" +
                    "FROM\n" +
                    "    information_schema.table_constraints AS tc\n" +
                    "JOIN\n" +
                    "    information_schema.key_column_usage AS kcu\n" +
                    "ON\n" +
                    "    tc.constraint_name = kcu.constraint_name\n" +
                    "WHERE\n" +
                    "    tc.table_name = '"+"';");
            resultSet.next();
            return type.equals(resultSet.getString(1));
        }
    }


}
