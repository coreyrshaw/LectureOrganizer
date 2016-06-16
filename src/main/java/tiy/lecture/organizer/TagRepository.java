package tiy.lecture.organizer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag, Integer> {

//    @Query("SELECT g FROM Note g WHERE g.getNotes Like ?1% ")
//List<Note>findByNote(String noteTag);
}
