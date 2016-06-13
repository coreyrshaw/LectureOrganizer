package tiy.lecture.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by kat on 6/10/2016.
 */

@RestController
public class LectureOrganizerJSONController {
    @Autowired
    NoteRepository notes;

    @Autowired
    UserRepository users;

    @RequestMapping(path = "/notes.json", method = RequestMethod.GET)
    public ArrayList<Note> jsonHome() {
        ArrayList<Note> noteList = new ArrayList<Note>();
        Iterable<Note> allNotes = notes.findAll();
        for (Note note : allNotes) {
            noteList.add(note);
        }

        return noteList;
    }

    ArrayList<Note> getAllNotes() {
        ArrayList<Note> noteList = new ArrayList<Note>();
        Iterable<Note> allNotes = notes.findAll();
        for (Note note : allNotes) {
            noteList.add(note);
        }

        return noteList;
    }

    @RequestMapping(path = "/editNote.json", method = RequestMethod.GET)
    public ArrayList<Note> EditNote(int noteID) {
        System.out.println("editing note with ID " + noteID);
        Note note = notes.findOne(noteID);
        note.noteName = "**" + note.noteName;
        notes.save(note);

        return getAllNotes();
    }

    @RequestMapping(path = "/deleteNote.json", method = RequestMethod.GET)
    public  ArrayList<Note> deleteNote(int noteID) throws Exception {
        System.out.println("Delete note with ID " + noteID);
        notes.delete(noteID);

        return getAllNotes();
    }

    @RequestMapping(path = "/addNote.json", method = RequestMethod.POST)
    public ArrayList<Note> addNote(HttpSession session, @RequestBody Note note) throws Exception {

        notes.save(note);

        return getAllNotes();
    }

    @RequestMapping(path = "/getUser.json", method = RequestMethod.POST)
    public User getUser(HttpSession session, Model model) throws Exception {
        User user = (User)session.getAttribute("user");
        System.out.println(user);
        return user;
    }



}
