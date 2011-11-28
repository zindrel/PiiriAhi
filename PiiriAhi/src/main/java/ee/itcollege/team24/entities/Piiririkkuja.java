package ee.itcollege.team24.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Priiririkkuja
 *
 */
@Entity
@Table(name="Priiririkkuja")
@RooToString
@RooEntity
public class Piiririkkuja implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long piiririkkuja_ID;
	
	private String eesnimi;
	
	private String perek_nimi;
	
	private static final long serialVersionUID = 1L;

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
   
}
