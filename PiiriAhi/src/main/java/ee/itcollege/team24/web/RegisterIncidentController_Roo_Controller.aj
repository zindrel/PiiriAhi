// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team24.web;

import ee.itcollege.team24.entities.IntsidendiLiik;
import ee.itcollege.team24.entities.Intsident;
import ee.itcollege.team24.entities.IsikIntsidendis;
import ee.itcollege.team24.entities.Piiriloik;
import ee.itcollege.team24.entities.PiirivalvurIntsidendis;
import ee.itcollege.team24.entities.VahtkondIntsidendis;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect RegisterIncidentController_Roo_Controller {
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String RegisterIncidentController.createForm(Model uiModel) {
        uiModel.addAttribute("intsident", new Intsident());
        addDateTimeFormatPatterns(uiModel);
        List dependencies = new ArrayList();
        if (Piiriloik.countPiiriloiks() == 0) {
            dependencies.add(new String[]{"piiriloik", "piiriloiks"});
        }
        if (IntsidendiLiik.countIntsidendiLiiks() == 0) {
            dependencies.add(new String[]{"intsidendiliik", "intsidendiliiks"});
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "registerincident/create";
    }
    
    @RequestMapping(value = "/{intsident_ID}", method = RequestMethod.GET)
    public String RegisterIncidentController.show(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("intsident", Intsident.findIntsident(intsident_ID));
        uiModel.addAttribute("itemId", intsident_ID);
        return "registerincident/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String RegisterIncidentController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("intsidents", Intsident.findIntsidentEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Intsident.countIntsidents() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("intsidents", Intsident.findAllIntsidents());
        }
        addDateTimeFormatPatterns(uiModel);
        return "registerincident/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String RegisterIncidentController.update(@Valid Intsident intsident, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("intsident", intsident);
            addDateTimeFormatPatterns(uiModel);
            return "registerincident/update";
        }
        uiModel.asMap().clear();
        intsident.merge();
        return "redirect:/registerincident/" + encodeUrlPathSegment(intsident.getIntsident_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{intsident_ID}", params = "form", method = RequestMethod.GET)
    public String RegisterIncidentController.updateForm(@PathVariable("intsident_ID") Long intsident_ID, Model uiModel) {
        uiModel.addAttribute("intsident", Intsident.findIntsident(intsident_ID));
        addDateTimeFormatPatterns(uiModel);
        return "registerincident/update";
    }
    
    @RequestMapping(value = "/{intsident_ID}", method = RequestMethod.DELETE)
    public String RegisterIncidentController.delete(@PathVariable("intsident_ID") Long intsident_ID, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Intsident.findIntsident(intsident_ID).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/registerincident";
    }
    
    @ModelAttribute("intsidendiliiks")
    public Collection<IntsidendiLiik> RegisterIncidentController.populateIntsidendiLiiks() {
        return IntsidendiLiik.findAllIntsidendiLiiks();
    }
    
    @ModelAttribute("intsidents")
    public Collection<Intsident> RegisterIncidentController.populateIntsidents() {
        return Intsident.findAllIntsidents();
    }
    
    @ModelAttribute("isikintsidendises")
    public Collection<IsikIntsidendis> RegisterIncidentController.populateIsikIntsidendises() {
        return IsikIntsidendis.findAllIsikIntsidendises();
    }
    
    @ModelAttribute("piiriloiks")
    public Collection<Piiriloik> RegisterIncidentController.populatePiiriloiks() {
        return Piiriloik.findAllPiiriloiks();
    }
    
    @ModelAttribute("piirivalvurintsidendises")
    public Collection<PiirivalvurIntsidendis> RegisterIncidentController.populatePiirivalvurIntsidendises() {
        return PiirivalvurIntsidendis.findAllPiirivalvurIntsidendises();
    }
    
    @ModelAttribute("vahtkondintsidendises")
    public Collection<VahtkondIntsidendis> RegisterIncidentController.populateVahtkondIntsidendises() {
        return VahtkondIntsidendis.findAllVahtkondIntsidendises();
    }
    
    void RegisterIncidentController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("intsident_avatud_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("intsident_muudetud_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("intsident_suletud_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("intsident_toimumise_algus_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("intsident_toimumise_lopp_date_format", "dd.MM.yyyy");
    }
    
    String RegisterIncidentController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
