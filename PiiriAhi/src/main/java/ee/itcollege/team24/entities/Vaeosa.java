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
import ee.itcollege.team24.entities.Vahtkond;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Vaeosa
 *
 */
@Entity
@Table(name="VAEOSA")
@RooToString
@RooEntity
public class Vaeosa implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vaeosa_ID;
	
	@Size(min = 1, max = 100)
	@NotNull
	private String nimetus;
	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "vaeosa")
	private Collection<Vahtkond> vahtkond;

	public Vaeosa() {
		super();
	}   
	public Long getVaeosa_ID() {
		return this.vaeosa_ID;
	}

	public void setVaeosa_ID(Long vaeosa_ID) {
		this.vaeosa_ID = vaeosa_ID;
	}   
	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}
	public Collection<Vahtkond> getVahtkond() {
	    return vahtkond;
	}
	public void setVahtkond(Collection<Vahtkond> param) {
	    this.vahtkond = param;
	}
   
}
