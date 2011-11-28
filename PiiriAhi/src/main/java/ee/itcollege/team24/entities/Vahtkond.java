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

/**
 * Entity implementation class for Entity: Vahtkond
 *
 */
@Entity
@Table(name="VAHTKOND")
@RooToString
@RooEntity
public class Vahtkond implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vahtkond_ID;
	
	@Size(min = 1, max = 20)
	@NotNull
	private String kood;
	
	@Size(min = 1, max = 60)
	@NotNull
	private String nimetus;
	
	private static final long serialVersionUID = 1L;

	public Vahtkond() {
		super();
	}   
	public Long getVahtkond_ID() {
		return this.vahtkond_ID;
	}

	public void setVahtkond_ID(Long vahtkond_ID) {
		this.vahtkond_ID = vahtkond_ID;
	}   
	public String getKood() {
		return this.kood;
	}

	public void setKood(String kood) {
		this.kood = kood;
	}   
	public String getNimetus() {
		return this.nimetus;
	}

	public void setNimetus(String nimetus) {
		this.nimetus = nimetus;
	}
   
}
