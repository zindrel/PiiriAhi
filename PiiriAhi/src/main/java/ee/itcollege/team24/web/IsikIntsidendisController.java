package ee.itcollege.team24.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.team24.entities.IsikIntsidendis;

@RooWebScaffold(path = "isikintsidendises", formBackingObject = IsikIntsidendis.class)
@RequestMapping("/isikintsidendises")
@Controller
public class IsikIntsidendisController {
	
	String referer;
	
	@RequestMapping(method = RequestMethod.POST)
    public String create(@Valid IsikIntsidendis isikIntsidendis, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("isikIntsidendis", isikIntsidendis);
            addDateTimeFormatPatterns(uiModel);
            return "isikintsidendises/create";
        }
        uiModel.asMap().clear();
        isikIntsidendis.persist();
        if (referer == null || referer.equals(""))
        	return "redirect:/isikintsidendises/" + encodeUrlPathSegment(isikIntsidendis.getIsik_intsidendis_ID().toString(), httpServletRequest);
        else
        	return "redirect:" + referer;
    }
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel, HttpServletRequest httpServletRequest) {
        uiModel.addAttribute("isikIntsidendis", new IsikIntsidendis());
        addDateTimeFormatPatterns(uiModel);
        referer = httpServletRequest.getHeader("referer");
        return "isikintsidendises/create";
    }
	
}
