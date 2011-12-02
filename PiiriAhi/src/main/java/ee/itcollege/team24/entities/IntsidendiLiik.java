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

/**
 * Entity implementation class for Entity: IntsidendiLiik
 *
 */
@Entity
@Table(name="INTSIDENDI_LIIK")
@RooToString
@RooEntity
public class IntsidendiLiik implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long intsidendi_liik_ID;
	
	@Size(min = 1, max = 60)
	@NotNull
	private String nimetus;
	
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "intsidendiLiik")
	private Collection<Intsident> intsidents;

	public IntsidendiLiik() {
		super();
	}   
	public Long getIntsidendi_liik_ID() {
		return this.intsidendi_liik_ID;
	}

	public void setIntsidendi_liik_ID(Long intsidendi_liik_ID) {
		this.intsidendi_liik_ID = intsidendi_liik_ID;
	}   
	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}
	public Collection<Intsident> getIntsidents() {
	    return intsidents;
	}
	public void setIntsident(Collection<Intsident> param) {
	    this.intsidents = param;
	}
   
}
