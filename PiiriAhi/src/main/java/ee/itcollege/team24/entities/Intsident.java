package ee.itcollege.team24.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * Entity implementation class for Entity: Intsident
 *
 */
@Entity
@Table(name="INTSIDENT")
@RooToString
@RooEntity
public class Intsident extends BaseHistoryEntity implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long intsident_ID;
	
	@Size(min = 1, max = 20)
	@NotNull
	private String kood;
	
	@Size(min = 1, max = 100)
	@NotNull
	private String nimetus;
	
	@DateTimeFormat(pattern="dd.MM.yyyy")
	@NotNull
	private Calendar toimumise_algus;
	
	@DateTimeFormat(pattern="dd.MM.yyyy")
	@NotNull
	private Calendar toimumise_lopp;
	
	@Digits(integer = 4, fraction = 5)
	@DecimalMax("180.0")
	@DecimalMin("0.0")
	private Double GPS_longituud;
	
	@Digits(integer = 4, fraction = 5)
	@DecimalMax("90.0")
	@DecimalMin("0.0")
	private Double GPS_latituud;
	
	@Size(min = 1, max = 150)
	@NotNull
	private String kirjeldus;
	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@NotNull
	private Piiriloik piiriloik;

	@OneToMany(mappedBy = "intsident")
	@Where(clause = "sulgeja = ''")
	private Collection<VahtkondIntsidendis> vahtkondIntsidendis;

	@OneToMany(mappedBy = "intsident")
	@Where(clause = "sulgeja = ''")
	private Collection<PiirivalvurIntsidendis> piirivalvurIntsidendis;

	@OneToMany(mappedBy = "intsident")
	@Where(clause = "sulgeja = ''")
	private Collection<ObjektIntsidendis> objektIntsidendis;

	@ManyToOne
	@NotNull
	private IntsidendiLiik intsidendiLiik;

	@OneToMany(mappedBy = "intsident")
	@Where(clause = "sulgeja = ''")
	private Collection<IsikIntsidendis> isikIntsidendis;

	public Intsident() {
		super();
	}   
	public Long getIntsident_ID() {
		return this.intsident_ID;
	}

	public void setIntsident_ID(Long intsident_ID) {
		this.intsident_ID = intsident_ID;
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
	public Calendar getToimumise_algus() {
		return this.toimumise_algus;
	}

	public void setToimumise_algus(Calendar toimumise_algus) {
		this.toimumise_algus = toimumise_algus;
	}   
	public Calendar getToimumise_lopp() {
		return this.toimumise_lopp;
	}

	public void setToimumise_lopp(Calendar toimumise_lopp) {
		this.toimumise_lopp = toimumise_lopp;
	}   
	public Double getGPS_longituud() {
		return this.GPS_longituud;
	}

	public void setGPS_longituud(Double GPS_longituud) {
		this.GPS_longituud = GPS_longituud;
	}   
	public Double getGPS_latituud() {
		return this.GPS_latituud;
	}

	public void setGPS_latituud(Double GPS_latituud) {
		this.GPS_latituud = GPS_latituud;
	}   
	public String getKirjeldus() {
		return this.kirjeldus;
	}

	public void setKirjeldus(String kirjeldus) {
		this.kirjeldus = kirjeldus;
	}
	public Piiriloik getPiiriloik() {
	    return piiriloik;
	}
	public void setPiiriloik(Piiriloik param) {
	    this.piiriloik = param;
	}
	public Collection<VahtkondIntsidendis> getVahtkondIntsidendis() {
	    return vahtkondIntsidendis;
	}
	public void setVahtkondIntsidendis(Collection<VahtkondIntsidendis> param) {
	    this.vahtkondIntsidendis = param;
	}
	public Collection<PiirivalvurIntsidendis> getPiirivalvurIntsidendis() {
	    return piirivalvurIntsidendis;
	}
	public void setPiirivalvurIntsidendis(Collection<PiirivalvurIntsidendis> param) {
	    this.piirivalvurIntsidendis = param;
	}
	public Collection<ObjektIntsidendis> getObjektsIntsidendis() {
	    return objektIntsidendis;
	}
	public void setObjektIntsidendis(Collection<ObjektIntsidendis> param) {
	    this.objektIntsidendis = param;
	}
	public IntsidendiLiik getIntsidendiLiik() {
	    return intsidendiLiik;
	}
	public void setIntsidendiLiik(IntsidendiLiik param) {
	    this.intsidendiLiik = param;
	}
	public Collection<IsikIntsidendis> getIsikIntsidendis() {
	    return isikIntsidendis;
	}
	public void setIsikIntsidendis(Collection<IsikIntsidendis> param) {
	    this.isikIntsidendis = param;
	}
   
}
