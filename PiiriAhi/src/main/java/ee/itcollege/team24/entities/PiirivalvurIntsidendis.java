package ee.itcollege.team24.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team24.entities.Piirivalvur;
import ee.itcollege.team24.entities.Intsident;
import javax.persistence.ManyToOne;
import ee.itcollege.team24.entities.VahtkondIntsidendis;

/**
 * Entity implementation class for Entity: PiirivalvurIntsidendis
 *
 */
@Entity
@Table(name="PIIRIVALVUR_INTSIDENDIS")
@Where(clause="sulgeja = ''")
@RooToString
@RooEntity
public class PiirivalvurIntsidendis extends BaseHistoryEntity implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long piirivalvur_intsidendis_ID;
	
	@DateTimeFormat(pattern="dd.MM.yyyy")
	@NotNull
	private Calendar alates;
	
	@DateTimeFormat(pattern="dd.MM.yyyy")
	@NotNull
	private Calendar kuni;
	
	@Size(min = 1, max = 150)
	@NotNull
	private String kirjeldus;
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@NotNull
	private Piirivalvur piirivalvur;

	@ManyToOne
	@NotNull
	private Intsident intsident;

	@ManyToOne
	private VahtkondIntsidendis vahtkondIntsidendis;

	public PiirivalvurIntsidendis() {
		super();
	}   
	public Long getPiirivalvur_intsidendis_ID() {
		return this.piirivalvur_intsidendis_ID;
	}

	public void setPiirivalvur_intsidendis_ID(Long piirivalvur_intsidendis_ID) {
		this.piirivalvur_intsidendis_ID = piirivalvur_intsidendis_ID;
	}   
	public Calendar getAlates() {
		return this.alates;
	}

	public void setAlates(Calendar alates) {
		this.alates = alates;
	}   
	public Calendar getKuni() {
		return this.kuni;
	}

	public void setKuni(Calendar kuni) {
		this.kuni = kuni;
	}   
	public String getKirjeldus() {
		return this.kirjeldus;
	}

	public void setKirjeldus(String kirjeldus) {
		this.kirjeldus = kirjeldus;
	}
	public Piirivalvur getPiirivalvur() {
	    return piirivalvur;
	}
	public void setPiirivalvur(Piirivalvur param) {
	    this.piirivalvur = param;
	}
	public Intsident getIntsident() {
	    return intsident;
	}
	public void setIntsident(Intsident param) {
	    this.intsident = param;
	}
	public VahtkondIntsidendis getVahtkondIntsidendis() {
	    return vahtkondIntsidendis;
	}
	public void setVahtkondIntsidendis(VahtkondIntsidendis param) {
	    this.vahtkondIntsidendis = param;
	}
   
}
