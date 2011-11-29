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
import ee.itcollege.team24.entities.Intsident;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Piiriloik
 *
 */
@Entity
@Table(name="PIIRILOIK")
@RooToString
@RooEntity
public class Piiriloik implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long piiriloik_ID;
	
	@Size(min = 1, max = 60)
	@NotNull
	private String nimetus;
	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "piiriloik")
	private Collection<Intsident> intsident;

	public Piiriloik() {
		super();
	}   
	public Long getPiiriloik_ID() {
		return this.piiriloik_ID;
	}

	public void setPiiriloik_ID(Long piiriloik_ID) {
		this.piiriloik_ID = piiriloik_ID;
	}   
	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}
	public Collection<Intsident> getIntsident() {
	    return intsident;
	}
	public void setIntsident(Collection<Intsident> param) {
	    this.intsident = param;
	}
   
}
