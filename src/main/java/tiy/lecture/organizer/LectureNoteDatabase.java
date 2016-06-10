package tiy.lecture.organizer;

import org.h2.tools.Server;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Sulton on 6/9/2016.
 */
public class LectureNoteDatabase {
    public final static String DB_URL = "jdbc:h2:./main";

    public void init() throws SQLException {
        Server.createWebServer().start();
        Connection conn = DriverManager.getConnection(DB_URL);
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS notes (id IDENTITY, text VARCHAR, language VARCHAR)");
    }

    public void insertNote(Connection conn, String text) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO notes VALUES (NULL, ?, ?)");
        stmt.setString(1, text);
        stmt.setString(2, text);
        stmt.execute();
    }

    public void deleteNote(Connection conn, String text) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM notes where text = ?");
        stmt.setString(1, text);
        stmt.execute();
    }

    public static ArrayList<Note> selectNote(Connection conn) throws SQLException {
        ArrayList<Note> notes = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("SELECT * FROM notes");
        while (results.next()) {
            int id = results.getInt("id");
            String text = results.getString("text");
            String language = results.getString("language");
            // notes.add(new Note(id, text, language));
        }
        return notes;
    }
}
