package ee.itcollege.team24.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import ee.itcollege.team24.entities.Piirivalvur;
import ee.itcollege.team24.entities.Vahtkond;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: VahtkonnaLiige
 *
 */
@Entity
@Table(name="VAHTKONNA_LIIGE")
@RooToString
@RooEntity
public class VahtkonnaLiige implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vahtkonna_liige_ID;
	
	@DateTimeFormat(pattern="dd.MM.yyyy")
	@NotNull
	private Calendar alates;
	
	@DateTimeFormat(pattern="dd.MM.yyyy")
	@NotNull
	private Calendar kuni;
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@NotNull
	private Piirivalvur piirivalvur;

	@ManyToOne
	@NotNull
	private Vahtkond vahtkond;

	public VahtkonnaLiige() {
		super();
	}   
	public Long getVahtkonna_liige_ID() {
		return this.vahtkonna_liige_ID;
	}

	public void setVahtkonna_liige_ID(Long vahtkonna_liige_ID) {
		this.vahtkonna_liige_ID = vahtkonna_liige_ID;
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
	public Piirivalvur getPiirivalvur() {
	    return piirivalvur;
	}
	public void setPiirivalvur(Piirivalvur param) {
	    this.piirivalvur = param;
	}
	public Vahtkond getVahtkond() {
	    return vahtkond;
	}
	public void setVahtkond(Vahtkond param) {
	    this.vahtkond = param;
	}
   
}
