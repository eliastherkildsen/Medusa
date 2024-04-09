package org.apollo.template.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Step 2: Connect to the SQLite database (if the database does not exist, it will be created)
            conn = DriverManager.getConnection("jdbc:sqlite:example.db");

            // Step 3: Create a Statement object to execute SQL commands
            stmt = conn.createStatement();

            // Step 4: Define SQL commands to create tables
            String createTableSQL = "CREATE TABLE IF NOT EXISTS MEDUSA_SCORE_TABLE (" +
                    "    name VARCHAR(32)," +
                    "    score INTEGER" +
                    ")";

            // Step 5: Execute SQL commands to create tables
            stmt.execute(createTableSQL);

            System.out.println("Database and table created successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the connection and statement
            try {
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
