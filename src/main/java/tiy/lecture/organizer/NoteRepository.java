package tiy.lecture.organizer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Justins PC on 5/22/2016.
 */
public interface NoteRepository extends CrudRepository<Note,Integer> {
//    @Query("SELECT g FROM Notes g WHERE g.noteSubject LIKE ?1%")
//    List<Note> findBySubject(String noteSubject);
//    List<Note> findByTag(String noteTag);
//    List<Note>fineByUser(User user);

    @Query("SELECT g FROM Note g WHERE g.noteTitle LIKE ?1%")
    List<Note> findByTitle(String noteTitle);

    @Query("SELECT g FROM Note g WHERE g.noteLanguage LIKE ?1%")
    List<Note> findByLanguage(String noteLanguage);

    @Query("SELECT g FROM Note g WHERE g.created_at LIKE ?1%")
    List<Note> findByDate(LocalDateTime created_at);

    List<Note>findByUser(User user);

    @Query("SELECT g FROM Note g WHERE g.noteTitle Like ?1% ")
    List<Note>findByNoteStartWith(String note);

    @Query("SELECT g FROM Note g WHERE g.noteTag Like ?1% ")
    List<Note>findByTag(String tag);


//    @Query("SELECT g FROM Tag g WHERE g.getNotes Like ?1% ")
//    List<Tag>findByTag(String tag);

}