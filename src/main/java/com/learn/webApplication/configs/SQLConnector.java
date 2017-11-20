package com.learn.webApplication.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

/**
 * Created by z002v2f on 17/11/17.
 */
@Configuration
public class SQLConnector {

    private static final Logger LOG = LoggerFactory.getLogger(SQLConnector.class);

    @Value("${sfmc.purge.db.driver}")
    private String driver;

    @Value("${sfmc.purge.db.url}")
    private String url;

    @Value("${sfmc.purge.db.username}")
    private String username;

    @Value("${sfmc.purge.db.password}")
    private String password;


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            LOG.error("Got Error in getting connection : ", e);
        }
        return connection;
    }

    public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (null != conn) conn.close();
            if (null != stmt) stmt.close();
            if (null != rs) rs.close();
        } catch (SQLException e) {
            LOG.error("Got Error in closing connection : ", e);
        }
    }

}
