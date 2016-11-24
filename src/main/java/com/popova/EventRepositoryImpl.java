package com.popova;

import java.sql.*;

public class EventRepositoryImpl implements EventRepository {

    private DatabaseCommandExecutor databaseCommandExecutor;

    public EventRepositoryImpl(DatabaseCommandExecutor databaseCommandExecutor) {
        this.databaseCommandExecutor = databaseCommandExecutor;
    }

    public void saveEvent(Event event) {
        SaveCommand saveCommand = (Connection connection) -> doSaveEvent(event, connection);
        databaseCommandExecutor.executeCommandWithConnection(saveCommand);
    }

    private void doSaveEvent(Event event, Connection connection) throws SQLException {
        String sql = "insert into Events"
                + "(user_id, event_type, event_timestamp) values "
                + "(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, event.getUserId());
        preparedStatement.setString(2, event.getEventType().toString());
        preparedStatement.setTimestamp(3, new Timestamp(event.getTimeStamp().getTime()));
        preparedStatement.executeUpdate();
    }

}
