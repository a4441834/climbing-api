package nl.redrock.climbersapi;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface  ClimberRepository extends CrudRepository<Climber, Long> {

    Climber findById(long id);
    
    Climber findByLastname(String Lastname);

}