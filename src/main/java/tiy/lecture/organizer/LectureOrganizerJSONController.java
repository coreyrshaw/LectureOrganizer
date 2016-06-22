package tiy.lecture.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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

    @RequestMapping(path = "/searchByName.json", method = RequestMethod.POST)
    public ArrayList<Note> getSearchNote(HttpSession session, @RequestBody String searchNoteTitle) throws Exception{
        System.out.println(searchNoteTitle);
        ArrayList<Note> noteList = new ArrayList<Note>();
        Iterable<Note> allNotes = notes.findByTitle(searchNoteTitle);
        for (Note note : allNotes) {
            noteList.add(note);
        }

        return noteList;
    }

    @RequestMapping(path = "/tagNotes.json", method = RequestMethod.POST)
    public ArrayList<Note> getTaggedNote(HttpSession session, @RequestBody Tag tag) throws Exception {
        System.out.println(tag.getId());

        ArrayList<Note> tagNoteList = new ArrayList<Note>();
        System.out.println(tagNoteList.size());

        ArrayList<Tag> tagList = new ArrayList<Tag>();

        tagList.add(tag);

        Iterable<Note> allTaggedNotes = notes.findByTags(tagList);
        for (Note tagNote : allTaggedNotes) {
            tagNoteList.add(tagNote);
        }
        System.out.println(tagNoteList.size());
        return tagNoteList;
    }

    @RequestMapping(path = "/languageNotes.json", method = RequestMethod.POST)
    public ArrayList<Note> getLanguageNote(HttpSession session, @RequestBody Language language) throws Exception {
        System.out.println(language.getId());

        ArrayList<Note> tagNoteList = new ArrayList<Note>();
        System.out.println(tagNoteList.size());

        ArrayList<Language> languageList = new ArrayList<Language>();

        languageList.add(language);

        Iterable<Note> allTaggedNotes = notes.findByLanguages(languageList);
        for (Note tagNote : allTaggedNotes) {
            tagNoteList.add(tagNote);
        }
        System.out.println(tagNoteList.size());
        return tagNoteList;
    }

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
        User user = (User)session.getAttribute("user");
        System.out.println("User from session::" + user);
//        System.out.println("User notes = " + user.getNotes());
        // Note: we need to clear the notes from the user before saving the user on the
        // note, because of a potential circular reference issue - TODO: figure out another way to do this
        user.setNotes(null);
        note.user = user;
        System.out.println("<=============================================================>");
        System.out.println("Title of the note that we are trying to add: " + note.noteTitle);
        System.out.println("The code of the note that we are trying to add: " + note.noteCode);
        System.out.println("This is the text of the code that we are trying to add: " + note.noteText);
        System.out.println("This is the text of the code that we are trying to add: " + note.getLanguages());
        for (Language language : note.getLanguages())  {
            System.out.println("\tLanguage::" + language.getId());
        }
        System.out.println("This is the text of the code that we are trying to add: " + note.getTags());
        for (Tag tag : note.getTags()) {
            System.out.println("\tTag::" + tag.getId());
        }
        System.out.println("<=============================================================>");
        notes.save(note);
        return getAllNotes();
    }

    @RequestMapping(path = "/editNote.json", method = RequestMethod.POST)
    public ArrayList<Note> editNote(HttpSession session, @RequestBody Note note) throws Exception {
        User user = (User)session.getAttribute("user");
        Note noteToEdit = notes.findOne(note.id);
        noteToEdit.noteText = note.noteText;
        noteToEdit.noteTitle = note.noteTitle;
        noteToEdit.noteCode = note.noteCode;
        noteToEdit.setLanguages(note.getLanguages());
        noteToEdit.setTags(note.getTags());
        System.out.println("User from session::" + user);
//        System.out.println("User notes = " + user.getNotes());
        // Note: we need to clear the notes from the user before saving the user on the
        // note, because of a potential circular reference issue - TODO: figure out another way to do this
        user.setNotes(null);
        note.user = user;
        System.out.println("<=============================================================>");
        System.out.println("Title of the note that we are trying to add: " + note.noteTitle);
        System.out.println("The code of the note that we are trying to add: " + note.noteCode);
        System.out.println("This is the text of the code that we are trying to add: " + note.noteText);
        System.out.println("This is the text of the code that we are trying to add: " + note.getLanguages());
        for (Language language : note.getLanguages())  {
            System.out.println("\tLanguage::" + language.getId());
        }
        System.out.println("This is the text of the code that we are trying to add: " + note.getTags());
        for (Tag tag : note.getTags()) {
            System.out.println("\tTag::" + tag.getId());
        }
        System.out.println("<=============================================================>");
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
    public ArrayList<Note> getTaggedNote(Tag tag) throws Exception {
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





}
