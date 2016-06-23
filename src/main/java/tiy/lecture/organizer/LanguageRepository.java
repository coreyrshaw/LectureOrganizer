package tiy.lecture.organizer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Integer> {

    @Query("SELECT g FROM Language g WHERE g.language LIKE ?1")
    List<Language>findByLanguage(String language);
}
