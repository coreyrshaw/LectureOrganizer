package tiy.lecture.organizer;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Sulton on 6/10/2016.
 */
@Entity
@Table(name="tags")
public class Tag {
    @ManyToMany()
    private Set<Note> notes;

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    //    @ManyToMany
//    Note note;

        @Id
        @GeneratedValue
        int id;

        @Column(nullable = false)
        String name;

        public Tag() {

        }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag(String name) {
           this.name = name;


        }

    }
