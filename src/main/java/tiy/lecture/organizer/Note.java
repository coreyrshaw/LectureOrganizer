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
    String noteTag;

    @Column (nullable = false)
    String noteCode;



    public String getNoteLanguage() {
        return noteLanguage;
    }

    public void setNoteLanguage(String noteLanguage) {
        this.noteLanguage = noteLanguage;
    }

    @Column (nullable = false)
    String noteLanguage;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column (nullable = false)
    LocalDateTime created_at;


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

    public String getNoteTag() {
        return noteTag;
    }

    public void setNoteTag(String noteTag) {
        this.noteTag = noteTag;
    }

    public String getNoteCode() {
        return noteCode;
    }

    public void setNoteCode(String noteCode) {
        this.noteCode = noteCode;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public Note(String noteText, String noteTag, String noteCode, LocalDateTime created_at , String noteLanguage, String noteTitle, User user) {
        this.noteCode = noteCode;
        this.noteText = noteText;
        this.noteTag = noteTag;
        this.user = user;
        this.noteTitle = noteTitle;
        this.created_at = created_at;
        this.noteLanguage = noteLanguage;


    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}

