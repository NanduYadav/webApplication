package com.learn.webApplication.dao;

import com.learn.webApplication.configs.SQLConnector;
import com.learn.webApplication.exceptions.DatabaseException;
import com.learn.webApplication.models.PurgeList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by z002v2f on 17/11/17.
 */
@Repository
public class PurgeListDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurgeListDao.class);

    private static final String MDM_SEQ_ID = "MDM_SEQUENCE_ID";
    private static final String GUEST_ID = "GUEST_ID";
    private static final String CREATED = "CREATED";
    private static final String STATUS = "STATUS";

    @Autowired
    private SQLConnector sqlConnector;

    public List<PurgeList> getMdmSeqIds() throws DatabaseException {
        List<PurgeList> list = new ArrayList<PurgeList>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM PURGE_LIST";
            connection = sqlConnector.getConnection();
            statement = connection.prepareStatement(query);
            //statement.setTimestamp(1, new Timestamp(startDate.getTime()));
            //statement.setTimestamp(2, new Timestamp(endDate.getTime()));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new PurgeList(resultSet.getLong(MDM_SEQ_ID),
                        resultSet.getLong(GUEST_ID), resultSet.getTimestamp(CREATED), resultSet.getString(STATUS)));
            }
        } catch (Exception e) {
            String message = "Error in reading data from DB " + e.getMessage();
            LOGGER.error(message);
            throw new DatabaseException(message, e);
        } finally {
            sqlConnector.closeAll(connection, statement, resultSet);
        }
        return list;
    }

}
