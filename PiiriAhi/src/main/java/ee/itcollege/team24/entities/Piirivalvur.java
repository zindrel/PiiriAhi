package ee.itcollege.team24.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team24.entities.PiirivalvurIntsidendis;
import java.util.Collection;
import javax.persistence.OneToMany;
import ee.itcollege.team24.entities.VahtkonnaLiige;

/**
 * Entity implementation class for Entity: Piirivalvur
 *
 */
@Entity
@Table(name="PIIRIVALVUR")
@RooToString
@RooEntity
public class Piirivalvur implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long piirivalvur_ID;
	
	@Size(min = 1, max = 25)
	@NotNull
	private String eesnimed;
	
	@Size(min = 1, max = 35)
	@NotNull
	private String perekonnanimi;
	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "piirivalvur")
	private Collection<PiirivalvurIntsidendis> piirivalvurIntsidendis;

	@OneToMany(mappedBy = "piirivalvur")
	private Collection<VahtkonnaLiige> vahtkonnaLiige;

	public Piirivalvur() {
		super();
	}   
	public Long getPiirivalvur_ID() {
		return this.piirivalvur_ID;
	}

	public void setPiirivalvur_ID(Long piirivalvur_ID) {
		this.piirivalvur_ID = piirivalvur_ID;
	}   
	public String getEesnimed() {
		return this.eesnimed;
	}

	public void setEesnimed(String eesnimed) {
		this.eesnimed = eesnimed;
	}   
	public String getPerekonnanimi() {
		return this.perekonnanimi;
	}

	public void setPerekonnanimi(String perekonnanimi) {
		this.perekonnanimi = perekonnanimi;
	}
	public Collection<PiirivalvurIntsidendis> getPiirivalvurIntsidendis() {
	    return piirivalvurIntsidendis;
	}
	public void setPiirivalvurIntsidendis(Collection<PiirivalvurIntsidendis> param) {
	    this.piirivalvurIntsidendis = param;
	}
	public Collection<VahtkonnaLiige> getVahtkonnaLiige() {
	    return vahtkonnaLiige;
	}
	public void setVahtkonnaLiige(Collection<VahtkonnaLiige> param) {
	    this.vahtkonnaLiige = param;
	}
   
}
