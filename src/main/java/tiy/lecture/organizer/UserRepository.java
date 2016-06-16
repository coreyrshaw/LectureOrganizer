package tiy.lecture.organizer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Integer>{

    @Query("SELECT g FROM User g WHERE g.email Like ?1% ")
    User findByEmail(String email);
}
