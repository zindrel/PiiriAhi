package ee.itcollege.team24.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	private String kood;
	
	private String nimetus;
	
	private Calendar toimumise_algus;
	
	private Calendar toimumise_lopp;
	
	private Double GPS_longituud;
	
	private Double GPS_latituud;
	
	private String kirjeldus;
	
	private static final long serialVersionUID = 1L;

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
   
}
