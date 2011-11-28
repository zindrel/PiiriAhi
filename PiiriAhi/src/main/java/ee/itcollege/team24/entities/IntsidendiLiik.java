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
 * Entity implementation class for Entity: IntsidendiLiik
 *
 */
@Entity
@Table(name="Intsidendi_Liik")
@RooToString
@RooEntity
public class IntsidendiLiik implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long intsidendi_liik_ID;
	
	private String nimetus;
	
	private static final long serialVersionUID = 1L;

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
   
}
