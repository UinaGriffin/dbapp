package com.popova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionRepositoryImpl implements RegionRepository {

    private DatabaseCommandExecutor databaseCommandExecutor;

    public RegionRepositoryImpl(DatabaseCommandExecutor databaseCommandExecutor) {
        this.databaseCommandExecutor = databaseCommandExecutor;
    }

    @Override
    public List<Integer> findAllRegionIds() {
        LoadCommand loadCommand = (Connection connection) -> doLoad(connection);
        return databaseCommandExecutor.executeLoadCommand(loadCommand);
    }

    private List<Integer> doLoad(Connection connection) throws SQLException {
        List<Integer> result = new ArrayList<>();
        String sql = "select region_code from Region";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int regionId = rs.getInt("region_code");
            result.add(regionId);
        }

        return result;
    }


}
