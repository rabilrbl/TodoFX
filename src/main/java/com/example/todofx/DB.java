package com.example.todofx;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DB {

    // we are using the in-memory H2 database
    private final static String DATABASE_URL = "jdbc:sqlite:TodoDB.sqlite";
    private final static String TABLE_NAME = "tasks";

    private final Connection conn;
    public static Connection Connector() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(DATABASE_URL);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public DB() {
        conn = Connector();
        String sql = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (\n"
                + " id integer PRIMARY KEY,\n"
                + " name text NOT NULL);";

        try{
            assert conn != null;
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String name) throws SQLException {
        String sql = "INSERT INTO "+TABLE_NAME+"(name) VALUES(?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.executeUpdate();
    }

    public List<String> selectAll() throws SQLException {
        String sql = "SELECT * FROM "+TABLE_NAME;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<String> res = new LinkedList<>();

        while (rs.next()) {
            res.add(rs.getString("name"));
        }

        return res;
    }
}
