package tiy.lecture.organizer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface NoteRepository extends CrudRepository<Note,Integer> {

    @Query("SELECT g FROM Note g WHERE LOWER (g.noteTitle) LIKE ?1%")
    List<Note>findByTitle(String noteTitle);

    @Query("SELECT g FROM Note g WHERE g.id LIKE ?1")
    List<Note>findById(Integer noteId);

    @Query("SELECT g FROM Language g WHERE g.language LIKE ?1%")
    List<Note>findByLanguage(Language language);

//    @Query("SELECT g FROM Note g WHERE g.created_at LIKE ?1%")
//    List<Note> findByDate(LocalDateTime created_at);

    List<Note>findByUser(User user);

    @Query("SELECT g FROM Tag g WHERE g.name Like ?1% ")
    List<Note>findByTag(Tag tag);

    @Query("SELECT g FROM Note g INNER JOIN g.tags gt WHERE gt IN (:tags)")
    List<Note>findByTags(@Param("tags") Collection<Tag> tags);

    @Query("SELECT g FROM Note g INNER JOIN g.languages gt WHERE gt IN (:languages)")
    List<Note>findByLanguages(@Param("languages") Collection<Language> languages);
}