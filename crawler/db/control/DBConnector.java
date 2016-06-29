package db.control;

import java.sql.*;

/**
 * Created by d.zhuchkov on 22.06.2016.
 */
public class DBConnector {
        public Connection conn = null;

    private static DBConnector instance;
    private final static String URL_CONNECTION = "jdbc:postgresql://79.135.239.250:5432/HameleoTest"; //79.135.239.250 192.168.1.12
    private final static String login = "postgres";
    private final static String pass = "123456";
    private Connection connection;

    private DBConnector() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            this.connection = DriverManager.getConnection(URL_CONNECTION, login, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

        public ResultSet runSql(String sql) throws SQLException {
            Statement sta = conn.createStatement();
            return sta.executeQuery(sql);
        }

        public boolean runSql2(String sql) throws SQLException {
            Statement sta = conn.createStatement();
            return sta.execute(sql);
        }

        @Override
        protected void finalize() throws Throwable {
            if (conn != null || !conn.isClosed()) {
                conn.close();
            }
        }
}

