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
 * Entity implementation class for Entity: IsikIntsidendis
 *
 */
@Entity
@Table(name="ISIK_INTSIDENDIS")
@RooToString
@RooEntity
public class IsikIntsidendis extends BaseHistoryEntity implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long isik_intsidendis_ID;
	
	private Calendar alates;
	
	private Calendar kuni;
	
	private String kirjeldus;
	
	private static final long serialVersionUID = 1L;

	public IsikIntsidendis() {
		super();
	}   
	public Long getIsik_intsidendis_ID() {
		return this.isik_intsidendis_ID;
	}

	public void setIsik_intsidendis_ID(Long isik_intsidendis_ID) {
		this.isik_intsidendis_ID = isik_intsidendis_ID;
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
   
}
