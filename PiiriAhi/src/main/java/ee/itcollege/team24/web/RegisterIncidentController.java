package ee.itcollege.team24.web;

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
}
