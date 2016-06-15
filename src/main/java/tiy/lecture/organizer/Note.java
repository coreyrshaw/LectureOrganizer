package tiy.lecture.organizer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Justins PC on 5/22/2016.
 */
@Entity
@Table(name="notes")
public class Note {

    @ManyToMany(mappedBy = "notes")
    private Set<Tag> tags;

    @ManyToMany
    private Set<Language>languages;

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public void addLanguage(Language language) {
        if (languages == null) {
            languages = new HashSet<Language>();
        }

        languages.add(language);
    }

    public void removeLanguage(Language language) {
        if (languages != null) {
            languages.remove(language);
        }
    }

    @OneToOne
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






    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




    public Note() {

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



    public Note(String noteText, String noteCode, String noteTitle, User user) {
        this.noteCode = noteCode;
        this.noteText = noteText;
        this.user = user;
        this.noteTitle = noteTitle;



    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}

