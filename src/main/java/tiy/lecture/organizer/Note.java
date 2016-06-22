package tiy.lecture.organizer;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name="notes")
public class Note {

    @ManyToMany
    private Collection<Tag> tags;

    public Collection<Tag> getTags() {
        return tags;
    }

    public void setTags(Collection<Tag> tags) {
        this.tags = tags;
    }

    @ManyToMany
    private Collection<Language>languages;

    public Collection<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Collection<Language> languages) {
        this.languages = languages;
    }

//    public void addLanguage(Language language) {
//        if (languages == null) {
//            languages = new HashSet<Language>();
//        }
//
//        languages.add(language);
//    }
//
//    public void removeLanguage(Language language) {
//        if (languages != null) {
//            languages.remove(language);
//        }
//    }

    @ManyToOne
    User user;

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String noteTitle;

    @Column(nullable = false)
    String noteText;


    @Column (nullable = false)
    String noteCode;

    public String getNoteLink() {
        return noteLink;
    }

    public void setNoteLink(String noteLink) {
        this.noteLink = noteLink;
    }

    @Column (nullable = false)
    String noteLink;


    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNoteCode() {
        return noteCode;
    }

    public void setNoteCode(String noteCode) {
        this.noteCode = noteCode;
    }

    public Note() {
    }

    public Note(String noteText, String noteCode, String noteTitle, String noteLink, User user) {
        this.noteCode = noteCode;
        this.noteText = noteText;
        this.user = user;
        this.noteTitle = noteTitle;
        this.noteLink = noteLink;
    }
}

