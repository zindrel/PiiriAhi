package ee.itcollege.team24.entities;

import java.util.Calendar;

/**
 * Base class for all entities that require modification history
 *
 */

public class BaseHistoryEntity {
	
	private String kommentaar;
	private String avaja;
	private Calendar avatud;
	private String muutja;
	private Calendar muudetud;
	private String sulgeja;
	private Calendar suletud;
	
	public String getKommentaar() {
		return kommentaar;
	}
	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}
	public String getAvaja() {
		return avaja;
	}
	public void setAvaja(String avaja) {
		this.avaja = avaja;
	}
	public Calendar getAvatud() {
		return avatud;
	}
	public void setAvatud(Calendar avatud) {
		this.avatud = avatud;
	}
	public String getMuutja() {
		return muutja;
	}
	public void setMuutja(String muutja) {
		this.muutja = muutja;
	}
	public Calendar getMuudetud() {
		return muudetud;
	}
	public void setMuudetud(Calendar muudetud) {
		this.muudetud = muudetud;
	}
	public String getSulgeja() {
		return sulgeja;
	}
	public void setSulgeja(String sulgeja) {
		this.sulgeja = sulgeja;
	}
	public Calendar getSuletud() {
		return suletud;
	}
	public void setSuletud(Calendar suletud) {
		this.suletud = suletud;
	}

}
