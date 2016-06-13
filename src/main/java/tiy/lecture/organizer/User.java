package tiy.lecture.organizer;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Justins PC on 5/23/2016.
 */
@Entity
@Table(name = "users")
public class User {


    @OneToMany
    Set<Note> notes;



    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String dateOfBirth;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @Column(nullable = false)
    String cohort;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }
    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public User() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String email, String password, String dateOfBirth, String cohort,  String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.cohort = cohort;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
