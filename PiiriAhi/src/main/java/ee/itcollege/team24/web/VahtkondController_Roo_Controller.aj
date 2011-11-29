// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team24.web;

import ee.itcollege.team24.entities.Vaeosa;
import ee.itcollege.team24.entities.Vahtkond;
import ee.itcollege.team24.entities.VahtkondIntsidendis;
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

privileged aspect VahtkondController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String VahtkondController.create(@Valid Vahtkond vahtkond, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkond", vahtkond);
            return "vahtkonds/create";
        }
        uiModel.asMap().clear();
        vahtkond.persist();
        return "redirect:/vahtkonds/" + encodeUrlPathSegment(vahtkond.getVahtkond_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String VahtkondController.createForm(Model uiModel) {
        uiModel.addAttribute("vahtkond", new Vahtkond());
        return "vahtkonds/create";
    }
    
    @RequestMapping(value = "/{vahtkond_ID}", method = RequestMethod.GET)
    public String VahtkondController.show(@PathVariable("vahtkond_ID") Long vahtkond_ID, Model uiModel) {
        uiModel.addAttribute("vahtkond", Vahtkond.findVahtkond(vahtkond_ID));
        uiModel.addAttribute("itemId", vahtkond_ID);
        return "vahtkonds/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String VahtkondController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            uiModel.addAttribute("vahtkonds", Vahtkond.findVahtkondEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) Vahtkond.countVahtkonds() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("vahtkonds", Vahtkond.findAllVahtkonds());
        }
        return "vahtkonds/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String VahtkondController.update(@Valid Vahtkond vahtkond, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkond", vahtkond);
            return "vahtkonds/update";
        }
        uiModel.asMap().clear();
        vahtkond.merge();
        return "redirect:/vahtkonds/" + encodeUrlPathSegment(vahtkond.getVahtkond_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{vahtkond_ID}", params = "form", method = RequestMethod.GET)
    public String VahtkondController.updateForm(@PathVariable("vahtkond_ID") Long vahtkond_ID, Model uiModel) {
        uiModel.addAttribute("vahtkond", Vahtkond.findVahtkond(vahtkond_ID));
        return "vahtkonds/update";
    }
    
    @RequestMapping(value = "/{vahtkond_ID}", method = RequestMethod.DELETE)
    public String VahtkondController.delete(@PathVariable("vahtkond_ID") Long vahtkond_ID, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Vahtkond.findVahtkond(vahtkond_ID).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/vahtkonds";
    }
    
    @ModelAttribute("vaeosas")
    public Collection<Vaeosa> VahtkondController.populateVaeosas() {
        return Vaeosa.findAllVaeosas();
    }
    
    @ModelAttribute("vahtkonds")
    public Collection<Vahtkond> VahtkondController.populateVahtkonds() {
        return Vahtkond.findAllVahtkonds();
    }
    
    @ModelAttribute("vahtkondintsidendises")
    public Collection<VahtkondIntsidendis> VahtkondController.populateVahtkondIntsidendises() {
        return VahtkondIntsidendis.findAllVahtkondIntsidendises();
    }
    
    @ModelAttribute("vahtkonnaliiges")
    public Collection<VahtkonnaLiige> VahtkondController.populateVahtkonnaLiiges() {
        return VahtkonnaLiige.findAllVahtkonnaLiiges();
    }
    
    String VahtkondController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
