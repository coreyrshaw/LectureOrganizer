package tiy.lecture.organizer;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sulton on 6/10/2016.
 */
public interface TagRepository extends CrudRepository<Tag, Integer> {

//    @Query("SELECT g FROM Note g WHERE g.getNotes Like ?1% ")
//List<Note>findByNote(String noteTag);
}
