package ee.itcollege.team24.dao;

import java.util.ArrayList;
import java.util.Collection;

import ee.itcollege.team24.entities.BaseHistoryEntity;
import ee.itcollege.team24.entities.Intsident;
import ee.itcollege.team24.entities.Vahtkond;

public class VahtkonnaIntsidendid_dao {
	
	private int intsidentideArv;

	private Vahtkond vahtkond;
	
	private Collection<Intsident> intsidendid;
	
	public VahtkonnaIntsidendid_dao () {
		this.intsidendid = new ArrayList<Intsident>();
		this.setIntsidentideArv(0);
	}

	public Vahtkond getVahtkond() {
		return vahtkond;
	}

	public void setVahtkond(Vahtkond vahtkond) {
		this.vahtkond = vahtkond;
	}

	public Collection<Intsident> getIntsidendid() {
		return intsidendid;
	}

	public void setIntsidendid(Collection<Intsident> intsidendid) {
		this.intsidendid = intsidendid;
	} 
	
	public void addIntsident(Intsident ints) {
		if(ints.getSuletud().equals(BaseHistoryEntity.GetSurrogateDate())){
		   this.intsidendid.add(ints);
		   this.intsidentideArv++;
		}
	}

	public int getIntsidentideArv() {
		return intsidentideArv;
	}

	public void setIntsidentideArv(int intsidentideArv) {
		this.intsidentideArv = intsidentideArv;
	}
	
}
