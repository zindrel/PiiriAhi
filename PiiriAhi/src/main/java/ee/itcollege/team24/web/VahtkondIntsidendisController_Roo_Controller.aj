// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team24.web;

import ee.itcollege.team24.entities.Intsident;
import ee.itcollege.team24.entities.PiirivalvurIntsidendis;
import ee.itcollege.team24.entities.Vahtkond;
import ee.itcollege.team24.entities.VahtkondIntsidendis;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect VahtkondIntsidendisController_Roo_Controller {
    
    @RequestMapping(value = "/{vahtkond_intsidendis_ID}", method = RequestMethod.GET)
    public String VahtkondIntsidendisController.show(@PathVariable("vahtkond_intsidendis_ID") Long vahtkond_intsidendis_ID, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("vahtkondintsidendis", VahtkondIntsidendis.findVahtkondIntsidendis(vahtkond_intsidendis_ID));
        uiModel.addAttribute("itemId", vahtkond_intsidendis_ID);
        return "vahtkondintsidendises/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String VahtkondIntsidendisController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("vahtkondintsidendises", VahtkondIntsidendis.findVahtkondIntsidendisEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) VahtkondIntsidendis.countVahtkondIntsidendises() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("vahtkondintsidendises", VahtkondIntsidendis.findAllVahtkondIntsidendises());
        }
        addDateTimeFormatPatterns(uiModel);
        return "vahtkondintsidendises/list";
    }
    
    @RequestMapping(value = "/{vahtkond_intsidendis_ID}", method = RequestMethod.DELETE)
    public String VahtkondIntsidendisController.delete(@PathVariable("vahtkond_intsidendis_ID") Long vahtkond_intsidendis_ID, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        VahtkondIntsidendis.findVahtkondIntsidendis(vahtkond_intsidendis_ID).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/vahtkondintsidendises";
    }
    
    @ModelAttribute("intsidents")
    public Collection<Intsident> VahtkondIntsidendisController.populateIntsidents() {
        return Intsident.findAllIntsidents();
    }
    
    @ModelAttribute("piirivalvurintsidendises")
    public Collection<PiirivalvurIntsidendis> VahtkondIntsidendisController.populatePiirivalvurIntsidendises() {
        return PiirivalvurIntsidendis.findAllPiirivalvurIntsidendises();
    }
    
    @ModelAttribute("vahtkonds")
    public Collection<Vahtkond> VahtkondIntsidendisController.populateVahtkonds() {
        return Vahtkond.findAllVahtkonds();
    }
    
    @ModelAttribute("vahtkondintsidendises")
    public Collection<VahtkondIntsidendis> VahtkondIntsidendisController.populateVahtkondIntsidendises() {
        return VahtkondIntsidendis.findAllVahtkondIntsidendises();
    }
    
    void VahtkondIntsidendisController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("vahtkondIntsidendis_avatud_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("vahtkondIntsidendis_muudetud_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("vahtkondIntsidendis_suletud_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("vahtkondIntsidendis_alates_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("vahtkondIntsidendis_kuni_date_format", "dd.MM.yyyy");
    }
    
    String VahtkondIntsidendisController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
