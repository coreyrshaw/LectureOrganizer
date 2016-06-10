package tiy.lecture.organizer;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Sulton on 6/9/2016.
 */

public class LectureNoteDatabaseTest {
    @Autowired
    NoteRepository notes;

    @Autowired
    UserRepository users;

    LectureNoteDatabase lectureNoteDatabase;

    @Before
    public void setUp() throws Exception {
        // lectureNoteDatabase = new LectureNoteDatabase();
        // lectureNoteDatabase.init();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    @Ignore
    public void initTest() throws Exception {


        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        PreparedStatement todoQuery = conn.prepareStatement("SELECT * FROM notes");
        ResultSet results = todoQuery.executeQuery();
        assertNotNull(results);

    }

    @Test
    @Ignore
    public void testInsertNote() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        String notes = "My first note";
        lectureNoteDatabase.insertNote(conn, notes);

        //Making sure I can Retrieve it
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM notes where text = ?");
        stmt.setString(1, notes);
        ResultSet results = stmt.executeQuery();
        assertNotNull(results);

        int numResults = 0;
        while (results.next()) {
            numResults++;
        }
        assertEquals(1, numResults);

        lectureNoteDatabase.deleteNote(conn, notes);


        results = stmt.executeQuery();
        numResults = 0;
        while (results.next()) {
            numResults++;
        }
        assertEquals(0, numResults);
    }

    @Test
    @Ignore
    public void testSelectAllNotes() throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:./main");
        String firstNote = "Fist Note";
        String secondNote = "Second Note";

        lectureNoteDatabase.insertNote(conn, firstNote);
        lectureNoteDatabase.insertNote(conn, secondNote);

        ArrayList<Note> notes = lectureNoteDatabase.selectNote(conn);
        System.out.println("Found " + notes.size() + " notes in the database");

        assertTrue("There should be at least 2 notes in the database (there are " +
                notes.size() + ")", notes.size() > 1);

       lectureNoteDatabase.deleteNote(conn, firstNote);
        lectureNoteDatabase.deleteNote(conn, secondNote);
    }



}