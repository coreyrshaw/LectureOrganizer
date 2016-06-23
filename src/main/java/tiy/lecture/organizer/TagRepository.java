package tiy.lecture.organizer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag, Integer> {

    @Query("SELECT g FROM Tag g WHERE g.name LIKE ?1")
    List<Tag>findByTag(String tag);
}
