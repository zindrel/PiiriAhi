// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team24.web;

import ee.itcollege.team24.entities.Piirivalvur;
import ee.itcollege.team24.entities.Vahtkond;
import ee.itcollege.team24.entities.VahtkonnaLiige;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
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

privileged aspect VahtkonnaLiigeController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String VahtkonnaLiigeController.create(@Valid VahtkonnaLiige vahtkonnaLiige, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkonnaLiige", vahtkonnaLiige);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkonnaliiges/create";
        }
        uiModel.asMap().clear();
        vahtkonnaLiige.persist();
        return "redirect:/vahtkonnaliiges/" + encodeUrlPathSegment(vahtkonnaLiige.getVahtkonna_liige_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String VahtkonnaLiigeController.createForm(Model uiModel) {
        uiModel.addAttribute("vahtkonnaLiige", new VahtkonnaLiige());
        addDateTimeFormatPatterns(uiModel);
        return "vahtkonnaliiges/create";
    }
    
    @RequestMapping(value = "/{vahtkonna_liige_ID}", method = RequestMethod.GET)
    public String VahtkonnaLiigeController.show(@PathVariable("vahtkonna_liige_ID") Long vahtkonna_liige_ID, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("vahtkonnaliige", VahtkonnaLiige.findVahtkonnaLiige(vahtkonna_liige_ID));
        uiModel.addAttribute("itemId", vahtkonna_liige_ID);
        return "vahtkonnaliiges/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String VahtkonnaLiigeController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("vahtkonnaliiges", VahtkonnaLiige.findVahtkonnaLiigeEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) VahtkonnaLiige.countVahtkonnaLiiges() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("vahtkonnaliiges", VahtkonnaLiige.findAllVahtkonnaLiiges());
        }
        addDateTimeFormatPatterns(uiModel);
        return "vahtkonnaliiges/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String VahtkonnaLiigeController.update(@Valid VahtkonnaLiige vahtkonnaLiige, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkonnaLiige", vahtkonnaLiige);
            addDateTimeFormatPatterns(uiModel);
            return "vahtkonnaliiges/update";
        }
        uiModel.asMap().clear();
        vahtkonnaLiige.merge();
        return "redirect:/vahtkonnaliiges/" + encodeUrlPathSegment(vahtkonnaLiige.getVahtkonna_liige_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{vahtkonna_liige_ID}", params = "form", method = RequestMethod.GET)
    public String VahtkonnaLiigeController.updateForm(@PathVariable("vahtkonna_liige_ID") Long vahtkonna_liige_ID, Model uiModel) {
        uiModel.addAttribute("vahtkonnaLiige", VahtkonnaLiige.findVahtkonnaLiige(vahtkonna_liige_ID));
        addDateTimeFormatPatterns(uiModel);
        return "vahtkonnaliiges/update";
    }
    
    @RequestMapping(value = "/{vahtkonna_liige_ID}", method = RequestMethod.DELETE)
    public String VahtkonnaLiigeController.delete(@PathVariable("vahtkonna_liige_ID") Long vahtkonna_liige_ID, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        VahtkonnaLiige.findVahtkonnaLiige(vahtkonna_liige_ID).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/vahtkonnaliiges";
    }
    
    @ModelAttribute("piirivalvurs")
    public Collection<Piirivalvur> VahtkonnaLiigeController.populatePiirivalvurs() {
        return Piirivalvur.findAllPiirivalvurs();
    }
    
    @ModelAttribute("vahtkonds")
    public Collection<Vahtkond> VahtkonnaLiigeController.populateVahtkonds() {
        return Vahtkond.findAllVahtkonds();
    }
    
    @ModelAttribute("vahtkonnaliiges")
    public Collection<VahtkonnaLiige> VahtkonnaLiigeController.populateVahtkonnaLiiges() {
        return VahtkonnaLiige.findAllVahtkonnaLiiges();
    }
    
    void VahtkonnaLiigeController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("vahtkonnaLiige_alates_date_format", "dd.MM.yyyy");
        uiModel.addAttribute("vahtkonnaLiige_kuni_date_format", "dd.MM.yyyy");
    }
    
    String VahtkonnaLiigeController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
