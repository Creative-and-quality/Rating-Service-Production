package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.function.IntBinaryOperator;

public class DBConnector {
    private static DBConnector instance;
    private final static String URL_CONNECTION = "jdbc:mysql://sashich.teperev.ru:3306/geekbrains?characterEncoding=utf-8";
    private final static String login = "monty";
    private final static String pass = "geekbrains_2016";
    private Connection connection;

    private DBConnector() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
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

    public boolean executeUpdate(final String sql) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement(sql);
            int resultSet = statement.executeUpdate();
            if (resultSet == 0) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return true;
    }

    private String[] getColums(ResultSetMetaData metaData) {  // метод получения имен колонок из результатов полученных из БД
        try {
            String[] res = new String[metaData.getColumnCount()];
            for (int i = 0; i < res.length; i++) {
                res[i] = metaData.getColumnName(i + 1);
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> executeSelect(String sql) {
        PreparedStatement preparedStatement = null;
        ArrayList<String> result = new ArrayList<>();
        try {
            preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            String[] columns = getColums(metaData);
            while (resultSet.next()) {
                for (String column : columns) {
                    result.add(String.valueOf(resultSet.getObject(column)));
                }
            }
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }
}

