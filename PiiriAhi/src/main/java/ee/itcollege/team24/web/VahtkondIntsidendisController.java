package ee.itcollege.team24.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.team24.entities.VahtkondIntsidendis;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
}
