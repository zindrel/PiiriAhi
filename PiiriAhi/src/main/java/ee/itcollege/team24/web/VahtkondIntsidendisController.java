package ee.itcollege.team24.web;

import java.util.Calendar;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.team24.entities.Intsident;
import ee.itcollege.team24.entities.PiirivalvurIntsidendis;
import ee.itcollege.team24.entities.Vahtkond;
import ee.itcollege.team24.entities.VahtkondIntsidendis;
import ee.itcollege.team24.entities.VahtkonnaLiige;

@RooWebScaffold(path = "vahtkondintsidendises", formBackingObject = VahtkondIntsidendis.class)
@RequestMapping("/vahtkondintsidendises")
@Controller
public class VahtkondIntsidendisController {
	
	String referer;
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid VahtkondIntsidendis vahtkondIntsidendis, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkondIntsidendis", vahtkondIntsidendis);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkondintsidendises/create";
        }
        uiModel.asMap().clear();
        vahtkondIntsidendis.persist();
        if (referer == null || referer.equals(""))
        	return "redirect:/vahtkondintsidendises/" + encodeUrlPathSegment(vahtkondIntsidendis.getVahtkond_intsidendis_ID().toString(), httpServletRequest);
        else
        	return "redirect:" + referer;
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel, HttpServletRequest httpServletRequest) {
        uiModel.addAttribute("vahtkondIntsidendis", new VahtkondIntsidendis());
        addDateTimeFormatPatterns(uiModel);
        referer = httpServletRequest.getHeader("referer");
        return "vahtkondintsidendises/create";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid VahtkondIntsidendis vahtkondIntsidendis, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkondIntsidendis", vahtkondIntsidendis);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkondintsidendises/update";
        }
        
        // checkbox functionality here
        if (vahtkondIntsidendis.getAddAllPiirivalvurs()) {
        	// find vahtkond
        	Vahtkond vahtkond = vahtkondIntsidendis.getVahtkond();
        	// find incident
        	Intsident intsident = vahtkondIntsidendis.getIntsident();
        	// find all piirivalvurs in that vahtkond
        	Collection<VahtkonnaLiige> members = vahtkond.getVahtkonnaLiige();
        	// date magic
        	Calendar eventStart = vahtkondIntsidendis.getAlates();
        	Calendar eventEnd = vahtkondIntsidendis.getKuni();
        	for ( VahtkonnaLiige vahtkonnaLiige : members ) {
        		Calendar memberStart = vahtkonnaLiige.getAlates();
        		Calendar memberEnd = vahtkonnaLiige.getKuni();
        		if (!memberStart.after(eventEnd) && !memberEnd.before(eventStart)) {
        			PiirivalvurIntsidendis piirivalvurIntsidendis = new PiirivalvurIntsidendis();
        			piirivalvurIntsidendis.setAlates(eventStart);
        			piirivalvurIntsidendis.setKuni(eventEnd);
        			piirivalvurIntsidendis.setKirjeldus(vahtkond.getNimetus());
        			piirivalvurIntsidendis.setIntsident(intsident);
        			piirivalvurIntsidendis.setPiirivalvur(vahtkonnaLiige.getPiirivalvur());
        			piirivalvurIntsidendis.setVahtkondIntsidendis(vahtkondIntsidendis);
        			piirivalvurIntsidendis.persist();
        		}
        	}
        }
        
        uiModel.asMap().clear();
        vahtkondIntsidendis.merge();
        
        return "redirect:/vahtkondintsidendises/" + encodeUrlPathSegment(vahtkondIntsidendis.getVahtkond_intsidendis_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{vahtkond_intsidendis_ID}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("vahtkond_intsidendis_ID") Long vahtkond_intsidendis_ID, Model uiModel) {
    	VahtkondIntsidendis vahtkondIntsidendis = VahtkondIntsidendis.findVahtkondIntsidendis(vahtkond_intsidendis_ID);
        uiModel.addAttribute("vahtkondIntsidendis", vahtkondIntsidendis);
        uiModel.addAttribute("intsident", vahtkondIntsidendis.getIntsident());
        uiModel.addAttribute("vahtkond", vahtkondIntsidendis.getVahtkond());
        addDateTimeFormatPatterns(uiModel);
        return "vahtkondintsidendises/update";
    }
	
}
