package com.popova;

import java.sql.*;

public class EventRepositoryImpl implements EventRepository {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/advertisement";
    private static final String DB_USER = "postgres";
    private static final String PASSWORD = "password";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Driver not found", e);
        }
    }

    public void saveEvent(Event event) {
        try (
               Connection conn = DriverManager.getConnection(DB_URL, DB_USER, PASSWORD)
        ){

            String sql = "insert into Events"
                    + "(user_id, event_type, event_timestamp) values "
                    + "(?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, event.getUserId());
            preparedStatement.setString(2, event.getEventType().toString());
            preparedStatement.setTimestamp(3, new Timestamp(event.getTimeStamp().getTime()));
            preparedStatement.executeUpdate();

        } catch (SQLException se) {
            throw new RuntimeException("Saving failed",se);
        }
    }
}
