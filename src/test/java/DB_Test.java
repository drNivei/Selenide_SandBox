import DB.DB_Methods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class DB_Test {
    private static final String db = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "12345678";

    private Connection connection;

    @BeforeEach
    public void setup() throws SQLException {
        connection = DriverManager.getConnection(db, user, password);
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS users");

            stmt.execute("CREATE TABLE users (" +
                    "id SERIAL PRIMARY KEY, " +
                    "username VARCHAR(50) NOT NULL, " +
                    "email VARCHAR(100) UNIQUE NOT NULL, " +
                    "password VARCHAR(100) NOT NULL)");

            stmt.execute("INSERT INTO users (username, email, password) VALUES " +
                    "('test_user', 'test@example.com', 'pass123'), " +
                    "('admin', 'admin@example.com', 'admin123')");

            stmt.execute("DROP TABLE IF EXISTS employees");

            stmt.execute("CREATE TABLE employees (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "position VARCHAR(100), " +
                    "salary DECIMAL(10, 2) NOT NULL," +
                    "hire_date DATE DEFAULT CURRENT_DATE)");

            stmt.execute("INSERT INTO employees (name, position, salary) VALUES " +
                   "('Peter', 'director', '123000'), " +
                    "('Larisa', 'cleaner', '20500')," +
                    "('Frank', 'manager', '35000')");
        }
    }

    @Test
    public void testDBUsers() throws SQLException {
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM users");
            resultSet.next();
            int count = resultSet.getInt(1);
            Assertions.assertEquals(2,count);
        }
    }
    @Test
    public void testTBEmployeeExists() throws SQLException {
            String schema = "public";
            String tableName = "employees";
            DB_Methods dbMethods = new DB_Methods();
            Assertions.assertTrue(dbMethods.isTableExists(schema, tableName, connection));
    }

    @Test
    public void testCheckColumnsTypes() throws SQLException {
        String schema = "public";
        String tableName = "employees";
        DB_Methods dbMethods = new DB_Methods();

        String column1Name = "id";
        String column1Type = "integer";
        Assertions.assertTrue(dbMethods.checkColumnType(schema,tableName,column1Name,column1Type,connection));

        String column2Name = "name";
        String column2Type = "character varying";
        Assertions.assertTrue(dbMethods.checkColumnType(schema,tableName,column2Name,column2Type,connection));

        String column3Name = "position";
        String column3Type = "character varying";
        Assertions.assertTrue(dbMethods.checkColumnType(schema,tableName,column3Name,column3Type,connection));

        String column4Name = "salary";
        String column4Type = "numeric";
        Assertions.assertTrue(dbMethods.checkColumnType(schema,tableName,column4Name,column4Type,connection));

        String column5Name = "hire_date";
        String column5Type = "date";
        Assertions.assertTrue(dbMethods.checkColumnType(schema,tableName,column5Name,column5Type,connection));
    }
}