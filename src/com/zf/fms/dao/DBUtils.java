package com.zf.fms.dao;

import java.sql.*;

/**
 * Created by Administrator on 2018/4/17 0017.
 */
public class DBUtils {
    public static Connection getConnection() throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/familyer","root","root");
    }

    /**
     *
     * @param connection
     */
    public static void close(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param connection
     */
    public static void close(PreparedStatement connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param connection
     */
    public static void close(ResultSet connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

