package tiy.lecture.organizer;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Sulton on 6/13/2016.
 */

@Entity
@Table(name="languages")
public class Language {


        @ManyToMany(mappedBy = "languages")
        private Set<Note> notes;

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





        @Id
        @GeneratedValue
        int id;

        @Column(nullable = false)
        String language;


       public Language(){

       }


        public Language(String language) {

            this.language = language;

        }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
