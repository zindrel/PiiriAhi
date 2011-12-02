package ee.itcollege.team24.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import ee.itcollege.team24.entities.ObjektIntsidendis;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RooWebScaffold(path = "objektintsidendises", formBackingObject = ObjektIntsidendis.class)
@RequestMapping("/objektintsidendises")
@Controller
public class ObjektIntsidendisController {
	
	String referer;
	
	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid ObjektIntsidendis objektIntsidendis, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("objektIntsidendis", objektIntsidendis);
            addDateTimeFormatPatterns(uiModel);
            return "objektintsidendises/create";
        }
        uiModel.asMap().clear();
        objektIntsidendis.persist();
        if (referer == null || referer.equals(""))
        	return "redirect:/objektintsidendises/" + encodeUrlPathSegment(objektIntsidendis.getObjekt_intsidendis_ID().toString(), httpServletRequest);
        else
        	return "redirect:" + referer;
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel, HttpServletRequest httpServletRequest) {
        uiModel.addAttribute("objektIntsidendis", new ObjektIntsidendis());
        addDateTimeFormatPatterns(uiModel);
        referer = httpServletRequest.getHeader("referer");
        return "objektintsidendises/create";
    }
	
}
