package ee.itcollege.team24.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Piiririkkuja
 *
 */
@Entity
@Table(name="PIIRIRIKKUJA")
@RooToString
@RooEntity
public class Piiririkkuja implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long piiririkkuja_ID;
	
	@Size(min = 1, max = 25)
	@NotNull
	private String eesnimi;
	
	@Size(min = 1, max = 35)
	@NotNull
	private String perek_nimi;
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Objekt objekt;

	@OneToMany(mappedBy = "piiririkkuja")
	private Collection<IsikIntsidendis> isikIntsidendis;

	public Piiririkkuja() {
		super();
	}   
	public Long getPiiririkkuja_ID() {
		return this.piiririkkuja_ID;
	}

	public void setPiiririkkuja_ID(Long piiririkkuja_ID) {
		this.piiririkkuja_ID = piiririkkuja_ID;
	}   
	public String getEesnimi() {
		return this.eesnimi;
	}

	public void setEesnimi(String eesnimi) {
		this.eesnimi = eesnimi;
	}   
	public String getPerek_nimi() {
		return this.perek_nimi;
	}

	public void setPerek_nimi(String perek_nimi) {
		this.perek_nimi = perek_nimi;
	}
	public Objekt getObjekt() {
	    return objekt;
	}
	public void setObjekt(Objekt param) {
	    this.objekt = param;
	}
	public Collection<IsikIntsidendis> getIsikIntsidendis() {
	    return isikIntsidendis;
	}
	public void setIsikIntsidendis(Collection<IsikIntsidendis> param) {
	    this.isikIntsidendis = param;
	}
   
}
