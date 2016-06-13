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
        String primitiveTypes;

        @Column(nullable = false)
        String userInput;

        @Column(nullable = false)
        String thread;

        @Column(nullable = false)
        String looping;

        @Column(nullable = false)
        String libaries;

        @Column(nullable = false)
        String gettersAndSetters;

        @Column(nullable = false)
        String dynamicDataStructures;

        @Column(nullable = false)
        String sQL;

        @Column(nullable = false)
        String exceptions;

        @Column(nullable = false)
        String sockets;

        @Column(nullable = false)
        String gitHub;

        @Column(nullable = false)
        String inheritance;

        @Column(nullable = false)
        String unitTesting;

        @Column(nullable = false)
        String Constructors;

        @Column(nullable = false)
        String javaFX;

        @Column(nullable = false)
        String hTML;

        @Column(nullable = false)
        String javaScript;

    @Column(nullable = false)
    String cSS;

        @Column(nullable = false)
        String encapsulation;

        @Column(nullable = false)
        String cMD;


        public Tag() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

//    public Note getNote() {
//        return note;
//    }
//
//    public void setNote(Note note) {
//        this.note = note;
//    }

        public String getcMD() {
            return cMD;
        }

        public void setcMD(String cMD) {
            this.cMD = cMD;
        }

        public String getEncapsulation() {
            return encapsulation;
        }

        public void setEncapsulation(String encapsulation) {
            this.encapsulation = encapsulation;
        }

    public String getJavaScript() {
        return javaScript;
    }

    public void setJavaScript(String javaScript) {
        this.javaScript = javaScript;
    }

    public String getcSS() {
        return cSS;
    }

    public void setcSS(String cSS) {
        this.cSS = cSS;
    }

    public String gethTML() {
            return hTML;
        }

        public void sethTML(String hTML) {
            this.hTML = hTML;
        }

        public String getJavaFX() {
            return javaFX;
        }

        public void setJavaFX(String javaFX) {
            this.javaFX = javaFX;
        }

        public String getConstructors() {
            return Constructors;
        }

        public void setConstructors(String constructors) {
            Constructors = constructors;
        }

        public String getUnitTesting() {
            return unitTesting;
        }

        public void setUnitTesting(String unitTesting) {
            this.unitTesting = unitTesting;
        }

        public String getInheritance() {
            return inheritance;
        }

        public void setInheritance(String inheritance) {
            this.inheritance = inheritance;
        }

        public String getSockets() {
            return sockets;
        }

        public void setSockets(String sockets) {
            this.sockets = sockets;
        }

        public String getGitHub() {
            return gitHub;
        }

        public void setGitHub(String gitHub) {
            this.gitHub = gitHub;
        }

        public String getExceptions() {
            return exceptions;
        }

        public void setExceptions(String exceptions) {
            this.exceptions = exceptions;
        }

        public String getsQL() {
            return sQL;
        }

        public void setsQL(String sQL) {
            this.sQL = sQL;
        }

        public String getDynamicDataStructures() {
            return dynamicDataStructures;
        }

        public void setDynamicDataStructures(String dynamicDataStructures) {
            this.dynamicDataStructures = dynamicDataStructures;
        }

        public String getGettersAndSetters() {
            return gettersAndSetters;
        }

        public void setGettersAndSetters(String gettersAndSetters) {
            this.gettersAndSetters = gettersAndSetters;
        }

        public String getLibaries() {
            return libaries;
        }

        public void setLibaries(String libaries) {
            this.libaries = libaries;
        }

        public String getLooping() {
            return looping;
        }

        public void setLooping(String looping) {
            this.looping = looping;
        }

        public String getThread() {
            return thread;
        }

        public void setThread(String thread) {
            this.thread = thread;
        }

        public String getPrimitiveTypes() {
            return primitiveTypes;
        }

        public void setPrimitiveTypes(String primitiveTypes) {
            this.primitiveTypes = primitiveTypes;
        }

        public String getUserInput() {
            return userInput;
        }

        public void setUserInput(String userInput) {
            this.userInput = userInput;
        }

        public Tag(String primitiveTypes, String userInput, String thread, String libaries, String gettersAndSetters, String dynamicDataStructures, String sQL, String exceptions, String sockets, String gitHub, String inheritance, String unitTesting, String constructors, String javaFX, String hTML, String javaScript, String cSS, String encapsulation, String cMD) {
            this.primitiveTypes = primitiveTypes;
            this.userInput = userInput;
            this.thread = thread;
            this.libaries = libaries;
            this.gettersAndSetters = gettersAndSetters;
            this.dynamicDataStructures = dynamicDataStructures;
            this.sQL = sQL;
            this.exceptions = exceptions;
            this.sockets = sockets;
            this.gitHub = inheritance;
            this.gitHub = gitHub;
            this.unitTesting = unitTesting;
            this.Constructors = constructors;
            this.javaFX = javaFX;
            this.hTML = hTML;
            this.javaScript = javaScript;
            this.cSS = cSS;
            this.encapsulation = encapsulation;
            this.cMD = cMD;


        }

    }
