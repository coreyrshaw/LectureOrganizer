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

    @Autowired
    TagRepository tags;

    @Autowired
    LanguageRepository langs;

    @RequestMapping(path = "/notes.json", method = RequestMethod.GET)
    public ArrayList<Note> jsonNotes() throws Exception{
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
        note.noteTitle = "**" + note.noteTitle;
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

    @RequestMapping(path = "/tags.json", method = RequestMethod.GET)
    public ArrayList<Tag> getAllTags() {
        ArrayList<Tag> tagList = new ArrayList<Tag>();
        Iterable<Tag> allTags = tags.findAll();
        for (Tag tag : allTags) {
            tagList.add(tag);
        }

        return tagList;
    }

    @RequestMapping(path = "/tagNotes.json", method = RequestMethod.GET)
    public ArrayList<Note> getTaggedNote(String tag) throws Exception {
        ArrayList<Note> tagNoteList = new ArrayList<Note>();
        Iterable<Note> allTaggedNotes = notes.findByTag(tag);
        for (Note tagNote : allTaggedNotes) {
            tagNoteList.add(tagNote);
        }
        return tagNoteList;
    }

    @RequestMapping(path = "/language.json", method = RequestMethod.GET)
    public ArrayList<Language> getLanguages() {
        ArrayList<Language> languageList = new ArrayList<Language>();
        Iterable<Language> allLanguages = langs.findAll();
        for (Language currentLang : allLanguages) {
            languageList.add(currentLang);
        }
        return languageList;
    }

    @RequestMapping(path = "/datedNotes.json", method = RequestMethod.GET)
    public ArrayList<Note> getDatedNotes(String noteDate) throws Exception {
        ArrayList<Note> datedNoteList = new ArrayList<Note>();
        Iterable<Note> allDatedNotes = notes.findByDate(noteDate);
        for (Note datedNote : allDatedNotes) {
            datedNoteList.add(datedNote);
        }
        return datedNoteList;
    }





}
