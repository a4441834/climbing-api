package nl.redrock.climbersapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/climber")
@Api(value="climbers-home", description="Operations to manage your local climbers database")
public class ClimbersDataController {

    private final static Logger LOGGER = Logger.getLogger(ClimbersDataController.class.getName());

    @Autowired
    ClimberRepository climberRepository;
    
    //-------------------Retrieve all climbers--------------------------------------------------------
    @RequestMapping(value = "", method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "View a list of climbers", response = Iterable.class)
    List<Climber> getClimbers() {
        List<Climber> result;
        LOGGER.log(Level.INFO, "Getting all climbers");
        result = new ArrayList();
        Iterable<Climber> climberList = climberRepository.findAll();
        for (Climber climber : climberList) {
            result.add(climber);
        }
        return result;
    }
    
    //-------------------Retrieve a climber by id--------------------------------------------------------
    @RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Get a climber by id", response = Climber.class)
    public Climber getClimber(@PathVariable long id) {
        Climber result;
        LOGGER.log(Level.INFO, "Getting climber with id " + id);
        result = climberRepository.findById(id);
        return result;
    }
  
    //-------------------Add a climber--------------------------------------------------------------------
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST, produces = "application/text")
    @ApiOperation(value = "Add a new climber")
    public ResponseEntity saveClimber(@RequestBody Climber input) {
        LOGGER.log(Level.INFO, "Saving climber " + input.getLastname());
        Climber climber = new Climber();
        climber.setFirstname(input.getFirstname());
        climber.setLastname(input.getLastname());    
	climberRepository.save(climber);
        return new ResponseEntity("Climber saved successfully", HttpStatus.OK);
    }
    
    //-------------------Delete a climber by id------------------------------------------------------------
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/text")
    @ApiOperation(value = "Delete a climber by id")
    public ResponseEntity deleteClimber(@PathVariable long id) {
        LOGGER.log(Level.INFO, "Deleting climber " + id);
	climberRepository.delete(id);
        return new ResponseEntity("Climber deleted successfully", HttpStatus.OK);
    }
}
