package com.popova;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface LoadCommand {

    List<Integer> load(Connection connection) throws SQLException;
}
