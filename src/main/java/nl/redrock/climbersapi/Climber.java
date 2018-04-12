package nl.redrock.climbersapi;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "climber")
public class Climber {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The generated climber id", hidden = true)
    private long id;
    @ApiModelProperty(notes = "The climbers firstname", required = true)
    private String firstname;
    @ApiModelProperty(notes = "The climbers lastname", required = true)
    private String lastname;
    
    
    public Climber(){
    }
    
    public Climber(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
 @Override
    public String toString() {
        return String.format("Climber[id=%d, code='%s', name='%s']",
                id, firstname, lastname);
    }

    
}