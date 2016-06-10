package tiy.lecture.organizer;

import org.h2.tools.Server;

import java.sql.*;

/**
 * Created by Sulton on 6/9/2016.
 */
public class DatabaseMain {
    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start();

        Connection conn = DriverManager.getConnection("jdbc:h2:./main");


//        Statement stmt = conn.createStatement();
//        stmt.execute("CREATE TABLE IF NOT EXISTS notes (id IDENTITY, note VARCHAR)");
//        stmt.execute("INSERT INTO players VALUES (NULL, 'First Note')");
//
//        PreparedStatement stmt3 = conn.prepareStatement("SELECT * FROM notes");
//        ResultSet results = stmt3.executeQuery();
//        while (results.next()) {
//            String playerName = results.getString("name");
//

        }
    }

