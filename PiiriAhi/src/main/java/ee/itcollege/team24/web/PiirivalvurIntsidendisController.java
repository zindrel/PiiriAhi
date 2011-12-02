package ee.itcollege.team24.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.team24.entities.PiirivalvurIntsidendis;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "piirivalvurintsidendises", formBackingObject = PiirivalvurIntsidendis.class)
@RequestMapping("/piirivalvurintsidendises")
@Controller
public class PiirivalvurIntsidendisController {
	
	String referer;
	
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid PiirivalvurIntsidendis piirivalvurIntsidendis, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("piirivalvurIntsidendis", piirivalvurIntsidendis);
            addDateTimeFormatPatterns(uiModel);
            return "piirivalvurintsidendises/create";
        }
        uiModel.asMap().clear();
        piirivalvurIntsidendis.persist();
        if (referer == null || referer.equals(""))
        	return "redirect:/piirivalvurintsidendises/" + encodeUrlPathSegment(piirivalvurIntsidendis.getPiirivalvur_intsidendis_ID().toString(), httpServletRequest);
        else
        	return "redirect:" + referer;
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel, HttpServletRequest httpServletRequest) {
        uiModel.addAttribute("piirivalvurIntsidendis", new PiirivalvurIntsidendis());
        addDateTimeFormatPatterns(uiModel);
        referer = httpServletRequest.getHeader("referer");
        return "piirivalvurintsidendises/create";
    }
	
}
