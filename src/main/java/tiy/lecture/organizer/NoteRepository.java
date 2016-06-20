package tiy.lecture.organizer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NoteRepository extends CrudRepository<Note,Integer> {

    @Query("SELECT g FROM Note g WHERE g.noteTitle LIKE ?1%")
    List<Note> findByTitle(String noteTitle);

    @Query("SELECT g FROM Note g WHERE g.id LIKE ?1")
    List<Note> findById(Integer noteId);

    @Query("SELECT g FROM Language g WHERE g.language LIKE ?1%")
    List<Note> findByLanguage(Language language);

//    @Query("SELECT g FROM Note g WHERE g.created_at LIKE ?1%")
//    List<Note> findByDate(LocalDateTime created_at);

    List<Note>findByUser(User user);

    @Query("SELECT g FROM Note g WHERE g.noteTitle Like ?1% ")
    List<Note>findByNoteStartWith(String note);

    @Query("SELECT g FROM Tag g WHERE g.name Like ?1% ")
   List<Note>findByTag(Tag tag);
}