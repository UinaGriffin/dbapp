package com.popova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseCommandExecutor {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/advertisement";
    private static final String DB_USER = "postgres";
    private static final String PASSWORD = "password";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Driver not found", e);
        }
    }

    public void executeCommandWithConnection(SaveCommand saveCommand) {
        Command<Connection, Void> command = connection -> {saveCommand.executeSave(connection);return null;};
        executeCommand(command);
    }

    public List<Integer> executeLoadCommand(LoadCommand loadCommand) {
        Command<Connection, List<Integer>> command = connection -> loadCommand.load(connection);
        return executeCommand(command);
    }

    public <T> T executeCommand(Command<Connection, T> command) {
        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD)
        ) {
            return command.execute(conn);
        } catch (SQLException se) {
            throw new RuntimeException("Command failed", se);
        }
    }

    private interface Command<T,R>{
        R execute(T input) throws SQLException;
    }
}
