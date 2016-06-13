package tiy.lecture.organizer;

import javax.persistence.*;
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



    @OneToOne
    User user;

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String noteName;

    @Column(nullable = false)
    String noteSubject;

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

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column (nullable = false)
    String noteDate;

    public String getNoteComment() {
        return noteComment;
    }

    public void setNoteComment(String noteComment) {
        this.noteComment = noteComment;
    }

    @Column (nullable = false)
    String noteComment;

    public Note() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteSubject() {
        return noteSubject;
    }

    public void setNoteSubject(String noteSubject) {
        this.noteSubject = noteSubject;
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

    public Note(String noteName, String noteSubject, String noteTag, String noteCode,String noteComment, String noteDate , String noteLanguage, User user) {
        this.noteCode = noteCode;
        this.noteName = noteName;
        this.noteSubject = noteSubject;
        this.noteTag = noteTag;
        this.user = user;
        this.noteDate = noteDate;
        this.noteComment = noteComment;
        this.noteLanguage = noteLanguage;


    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}

