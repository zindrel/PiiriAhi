package ee.itcollege.team24.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.team24.dao.VahtkonnaIntsidendid_dao;
import ee.itcollege.team24.entities.Intsident;
import ee.itcollege.team24.entities.Piiriloik;
import ee.itcollege.team24.entities.Vahtkond;
import ee.itcollege.team24.entities.VahtkondIntsidendis;

@RequestMapping("/intidentpiiril/**")
@Controller
public class IntidentPiirilController {

    @RequestMapping
    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    	modelMap.addAttribute("piiriloiks",Piiriloik.findAllPiiriloiks());
    	modelMap.addAttribute("intsidents",Intsident.findAllIntsidents());
    	modelMap.addAttribute("number",Intsident.countIntsidents());
        return "intidentpiiril/index";
    }
    
    @RequestMapping(method = RequestMethod.GET, params = "loik")
    public String displayArea(@RequestParam(value = "loik", required = false) Long loik, Model uiModel) {
    	uiModel.addAttribute("piiriloiks",Piiriloik.findAllPiiriloiks());
    	
    	List<Vahtkond> koikVahtkonnad = Vahtkond.findAllVahtkonds();
    	List<VahtkondIntsidendis> vahtkonnadIntsidendis = VahtkondIntsidendis.findAllVahtkondIntsidendises();
    	List<VahtkonnaIntsidendid_dao> vahtkonnaIntsidendid = new ArrayList<VahtkonnaIntsidendid_dao>();
    	
    	for (Vahtkond vaht : koikVahtkonnad) {
    		
    		VahtkonnaIntsidendid_dao intsiVahtkond = new VahtkonnaIntsidendid_dao();
    		
    		intsiVahtkond.setVahtkond(vaht);
    	
	    	for (VahtkondIntsidendis v: vahtkonnadIntsidendis) {
	    		
	    		if (vaht.equals(v.getVahtkond())) {
	    			
	    			//Lisame ainult vastava piiriloigu intsidendid voi kui -1 siis koik
	    			if (loik.equals(new Long(-1)) || (v.getIntsident().getPiiriloik().getPiiriloik_ID().equals(loik)) ) {
	    				intsiVahtkond.addIntsident(v.getIntsident());
	    			}
	    			
	    		}
	
	    	}
	    	
	    	// Kuvame ainult siis kui antud vahkonnal on sellel piiriloigul intsidente
	    	if(intsiVahtkond.getIntsidentideArv() > 0) {
	    		vahtkonnaIntsidendid.add(intsiVahtkond);
	    	}
    	}	
    	
    	uiModel.addAttribute("vahtIntsidendid", vahtkonnaIntsidendid);
    	uiModel.addAttribute("piiril", loik);
    	
        return "intidentpiiril/index";
    }

    
}
