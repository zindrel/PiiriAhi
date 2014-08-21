package ee.itcollege.team24.web;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.team24.entities.*;




@RequestMapping("/filldb")
@Controller
public class FillDbController {

	@PersistenceContext
	EntityManager entityManager;
	
	@RequestMapping(method = RequestMethod.GET)
    public String fill(Model uiModel) throws IllegalStateException, SecurityException, SystemException {
		Query q = entityManager.createQuery("SELECT count(o) FROM Intsident o", Long.class);		
		
		if(((Long) q.getSingleResult()) == 0) {	  //ühtegi kirjet pole
			
			Calendar now = Calendar.getInstance();
			
			IntsidendiLiik il_1 = new IntsidendiLiik();
			il_1.setNimetus("Viinavedu");
			il_1.persist();
			
			Piiriloik p_1 = new Piiriloik();
			p_1.setNimetus("piiriloik_1");
			p_1.persist();
			Piiriloik p_2 = new Piiriloik();
			p_2.setNimetus("piiriloik_2");
			p_2.persist();
			
			Intsident i_1 = new Intsident();
			i_1.setKood("I44");
			i_1.setNimetus("Karu jooksis üle tee");
			i_1.setKirjeldus("väga hull");
			i_1.setToimumise_algus(now);
			i_1.setToimumise_lopp(now);
			i_1.setPiiriloik(p_1);
			i_1.setIntsidendiLiik(il_1);
			i_1.persist();
			
			Objekt o_1 = new Objekt();
			o_1.setNimetus("nuga");
			Objekt o_2 = new Objekt();
			o_2.setNimetus("AK-47");
			o_1.persist();
			o_2.persist();
			
			ObjektIntsidendis oi_1 = new ObjektIntsidendis();
			oi_1.setKirjeldus("kirjeldus");
			oi_1.setAlates(now);
			oi_1.setKuni(now);
			oi_1.setObjekt(o_2);
			oi_1.setIntsident(i_1);
			oi_1.persist();
			
			Piiririkkuja pr_1 = new Piiririkkuja();
			pr_1.setObjekt(o_2);
			pr_1.setEesnimi("Vova");
			pr_1.setPerek_nimi("Slava");
			pr_1.persist();
			
			IsikIntsidendis ii_1 = new IsikIntsidendis();
			ii_1.setIntsident(i_1);
			ii_1.setKirjeldus("kirjeldus");
			ii_1.setPiiririkkuja(pr_1);
			ii_1.setAlates(now);
			ii_1.setKuni(now);
			ii_1.persist();
			
			Piirivalvur pv_1 = new Piirivalvur();
			pv_1.setEesnimed("Vova");
			pv_1.setPerekonnanimi("Misha");
			pv_1.persist();
			Piirivalvur pv_2 = new Piirivalvur();
			pv_2.setEesnimed("Dima");
			pv_2.setPerekonnanimi("Sasha");
			pv_2.persist();

			Vaeosa v_1 = new Vaeosa();
			v_1.setNimetus("vaeosa");
			v_1.persist();
			
			Vahtkond vk_1 = new Vahtkond();
			vk_1.setKood("VK3242");
			vk_1.setNimetus("öine");
			vk_1.setVaeosa(v_1);
			vk_1.persist();
			Vahtkond vk_2 = new Vahtkond();
			vk_2.setKood("VDew42");
			vk_2.setNimetus("päevane");
			vk_2.setVaeosa(v_1);
			vk_2.persist();
			
			VahtkonnaLiige vkl_1 = new VahtkonnaLiige();
			vkl_1.setAlates(now);
			vkl_1.setKuni(now);
			vkl_1.setPiirivalvur(pv_2);
			vkl_1.setVahtkond(vk_1);
			vkl_1.persist();
					
			VahtkondIntsidendis vki_1 = new VahtkondIntsidendis();
			vki_1.setAlates(now);
			vki_1.setKuni(now);
			vki_1.setIntsident(i_1);
			vki_1.setKirjeldus("jube");
			vki_1.setVahtkond(vk_1);
			vki_1.persist();
			VahtkondIntsidendis vki_2 = new VahtkondIntsidendis();
			vki_2.setAlates(now);
			vki_2.setKuni(now);
			vki_2.setIntsident(i_1);
			vki_2.setKirjeldus("wtf");
			vki_2.setVahtkond(vk_2);
			vki_2.persist();
			
			PiirivalvurIntsidendis pvi_1 = new PiirivalvurIntsidendis();
			pvi_1.setAlates(now);
			pvi_1.setKuni(now);
			pvi_1.setIntsident(i_1);
			pvi_1.setKirjeldus("what?");
			pvi_1.setPiirivalvur(pv_2);
			pvi_1.setVahtkondIntsidendis(vki_1);
			pvi_1.persist();

			
		}

		return "redirect:/";
    }
	
}
