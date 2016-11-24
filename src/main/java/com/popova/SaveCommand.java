package com.popova;

import java.sql.Connection;
import java.sql.SQLException;

public interface SaveCommand {
    void executeSave(Connection connection) throws SQLException;
}
