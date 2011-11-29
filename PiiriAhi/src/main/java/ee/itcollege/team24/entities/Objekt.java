package ee.itcollege.team24.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team24.entities.Piiririkkuja;

/**
 * Entity implementation class for Entity: Objekt
 *
 */
@Entity
@Table(name="OBJEKT")
@RooToString
@RooEntity
public class Objekt implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long objekt_ID;
	
	@Size(min = 1, max = 100)
	@NotNull
	private String nimetus;
	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "objekt")
	private Collection<ObjektIntsidendis> objektIntsidendis;

	@OneToMany(mappedBy = "objekt")
	private Collection<Piiririkkuja> piiririkkujas;

	public Objekt() {
		super();
	}   
	public Long getObjekt_ID() {
		return this.objekt_ID;
	}

	public void setObjekt_ID(Long objekt_ID) {
		this.objekt_ID = objekt_ID;
	}   
	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}
	public Collection<ObjektIntsidendis> getObjektIntsidendis() {
	    return objektIntsidendis;
	}
	public void setObjektIntsidendis(Collection<ObjektIntsidendis> param) {
	    this.objektIntsidendis = param;
	}
	public Collection<Piiririkkuja> getPiiririkkujas() {
	    return piiririkkujas;
	}
	public void setPiiririkkujas(Collection<Piiririkkuja> param) {
	    this.piiririkkujas = param;
	}
   
}
