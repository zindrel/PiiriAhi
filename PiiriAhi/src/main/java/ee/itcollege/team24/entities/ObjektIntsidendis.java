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
import ee.itcollege.team24.entities.Objekt;
import ee.itcollege.team24.entities.Intsident;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: ObjektIntsidendis
 *
 */
@Entity
@Table(name="OBJEKT_INTSIDENDIS")
@Where(clause="sulgeja = ''")
@RooToString
@RooEntity
public class ObjektIntsidendis extends BaseHistoryEntity implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long objekt_intsidendis_ID;
	
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
	private Objekt objekt;

	@ManyToOne
	@NotNull
	private Intsident intsident;

	public ObjektIntsidendis() {
		super();
	}   
	public Long getObjekt_intsidendis_ID() {
		return this.objekt_intsidendis_ID;
	}

	public void setObjekt_intsidendis_ID(Long objekt_intsidendis_ID) {
		this.objekt_intsidendis_ID = objekt_intsidendis_ID;
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
	public Objekt getObjekt() {
	    return objekt;
	}
	public void setObjekt(Objekt param) {
	    this.objekt = param;
	}
	public Intsident getIntsident() {
	    return intsident;
	}
	public void setIntsident(Intsident param) {
	    this.intsident = param;
	}
   
}
