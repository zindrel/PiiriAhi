package ee.itcollege.team24.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ee.itcollege.team24.entities.Intsident;
import ee.itcollege.team24.entities.IsikIntsidendis;
import ee.itcollege.team24.entities.ObjektIntsidendis;
import ee.itcollege.team24.entities.PiirivalvurIntsidendis;
import ee.itcollege.team24.entities.VahtkondIntsidendis;

@RooWebScaffold(path = "registerincident", formBackingObject = Intsident.class)
@RequestMapping("/registerincident")
@Controller
public class RegisterIncidentController {
	
	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Intsident intsident, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("intsident", intsident);
            addDateTimeFormatPatterns(uiModel);
            return "registerincident/create";
        }
        if(intsident.getToimumise_algus().after(intsident.getToimumise_lopp())){
            uiModel.addAttribute("intsident", intsident);
            addDateTimeFormatPatterns(uiModel);
            bindingResult.addError(new ObjectError("toimumise_lopp","Intsidendi toimumise lõpp peab olema hiljem kui algus!"));
            return "registerincident/create";
        }
        uiModel.asMap().clear();
        intsident.persist();
        return "redirect:/registerincident/createdetails/" + encodeUrlPathSegment(intsident.getIntsident_ID().toString(), httpServletRequest);
    }
	
	@RequestMapping(value = "/createdetails/{intsident_ID}", method = RequestMethod.GET)
    public String createDetails(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("intsident", Intsident.findIntsident(intsident_ID));
        uiModel.addAttribute("itemId", intsident_ID);
        return "registerincident/createdetails";
    }
	
	@RequestMapping(value = "/createdetails/{intsident_ID}", method = RequestMethod.GET, params = "object")
    public String close(@PathVariable("intsident_ID") Long intsident_ID, @RequestParam(value = "object", required = false) String objectDescription, Model uiModel, HttpServletRequest httpServletRequest) {
		
        String[] objectParams = objectDescription.split(",");
        
        if (objectParams[0].equals("isik")) {
        	IsikIntsidendis isikIntsidendis = IsikIntsidendis.findIsikIntsidendis(Long.parseLong(objectParams[1]));
        	isikIntsidendis.close();
        	isikIntsidendis.persist();
        }
        else if (objectParams[0].equals("objekt")) {
        	ObjektIntsidendis objektIntsidendis = ObjektIntsidendis.findObjektIntsidendis(Long.parseLong(objectParams[1]));
        	objektIntsidendis.close();
        	objektIntsidendis.persist();
        }
        else if (objectParams[0].equals("vahtkond")) {
        	VahtkondIntsidendis vahtkondIntsidendis = VahtkondIntsidendis.findVahtkondIntsidendis(Long.parseLong(objectParams[1]));
        	vahtkondIntsidendis.close();
        	vahtkondIntsidendis.persist();
        }
        else if (objectParams[0].equals("valvur")) {
        	PiirivalvurIntsidendis piirivalvurIntsidendis = PiirivalvurIntsidendis.findPiirivalvurIntsidendis(Long.parseLong(objectParams[1]));
        	piirivalvurIntsidendis.close();
        	piirivalvurIntsidendis.persist();
        }
        
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("intsident", Intsident.findIntsident(intsident_ID));
        uiModel.addAttribute("itemId", intsident_ID);
        return "redirect:/registerincident/createdetails/" + encodeUrlPathSegment(intsident_ID.toString(), httpServletRequest);
    }
	
}
