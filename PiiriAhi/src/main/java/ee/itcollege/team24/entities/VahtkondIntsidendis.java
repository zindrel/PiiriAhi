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
import ee.itcollege.team24.entities.Vahtkond;
import ee.itcollege.team24.entities.Intsident;
import javax.persistence.ManyToOne;
import ee.itcollege.team24.entities.PiirivalvurIntsidendis;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: VahtkondIntsidendis
 *
 */
@Entity
@Table(name="VAHTKOND_INTSIDENDIS")
@Where(clause="sulgeja = ''")
@RooToString
@RooEntity
public class VahtkondIntsidendis extends BaseHistoryEntity implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vahtkond_intsidendis_ID;
	
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
	private Vahtkond vahtkond;

	@ManyToOne
	@NotNull
	private Intsident intsident;

	@OneToMany(mappedBy = "vahtkondIntsidendis")
	private Collection<PiirivalvurIntsidendis> piirivalvurIntsidendis;

	public VahtkondIntsidendis() {
		super();
	}   
	public Long getVahtkond_intsidendis_ID() {
		return this.vahtkond_intsidendis_ID;
	}

	public void setVahtkond_intsidendis_ID(Long vahtkond_intsidendis_ID) {
		this.vahtkond_intsidendis_ID = vahtkond_intsidendis_ID;
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
	public Vahtkond getVahtkond() {
	    return vahtkond;
	}
	public void setVahtkond(Vahtkond param) {
	    this.vahtkond = param;
	}
	public Intsident getIntsident() {
	    return intsident;
	}
	public void setIntsident(Intsident param) {
	    this.intsident = param;
	}
	public Collection<PiirivalvurIntsidendis> getPiirivalvurIntsidendis() {
	    return piirivalvurIntsidendis;
	}
	public void setPiirivalvurIntsidendis(Collection<PiirivalvurIntsidendis> param) {
	    this.piirivalvurIntsidendis = param;
	}
   
}
