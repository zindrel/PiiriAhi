// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ee.itcollege.team24.web;

import ee.itcollege.team24.entities.VahtkondIntsidendis;
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

privileged aspect VahtkondIntsidendisController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String VahtkondIntsidendisController.create(@Valid VahtkondIntsidendis vahtkondIntsidendis, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkondIntsidendis", vahtkondIntsidendis);
            return "vahtkondintsidendises/create";
        }
        uiModel.asMap().clear();
        vahtkondIntsidendis.persist();
        return "redirect:/vahtkondintsidendises/" + encodeUrlPathSegment(vahtkondIntsidendis.getVahtkond_intsidendis_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String VahtkondIntsidendisController.createForm(Model uiModel) {
        uiModel.addAttribute("vahtkondIntsidendis", new VahtkondIntsidendis());
        return "vahtkondintsidendises/create";
    }
    
    @RequestMapping(value = "/{vahtkond_intsidendis_ID}", method = RequestMethod.GET)
    public String VahtkondIntsidendisController.show(@PathVariable("vahtkond_intsidendis_ID") Long vahtkond_intsidendis_ID, Model uiModel) {
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
        return "vahtkondintsidendises/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String VahtkondIntsidendisController.update(@Valid VahtkondIntsidendis vahtkondIntsidendis, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("vahtkondIntsidendis", vahtkondIntsidendis);
            return "vahtkondintsidendises/update";
        }
        uiModel.asMap().clear();
        vahtkondIntsidendis.merge();
        return "redirect:/vahtkondintsidendises/" + encodeUrlPathSegment(vahtkondIntsidendis.getVahtkond_intsidendis_ID().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{vahtkond_intsidendis_ID}", params = "form", method = RequestMethod.GET)
    public String VahtkondIntsidendisController.updateForm(@PathVariable("vahtkond_intsidendis_ID") Long vahtkond_intsidendis_ID, Model uiModel) {
        uiModel.addAttribute("vahtkondIntsidendis", VahtkondIntsidendis.findVahtkondIntsidendis(vahtkond_intsidendis_ID));
        return "vahtkondintsidendises/update";
    }
    
    @RequestMapping(value = "/{vahtkond_intsidendis_ID}", method = RequestMethod.DELETE)
    public String VahtkondIntsidendisController.delete(@PathVariable("vahtkond_intsidendis_ID") Long vahtkond_intsidendis_ID, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        VahtkondIntsidendis.findVahtkondIntsidendis(vahtkond_intsidendis_ID).remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/vahtkondintsidendises";
    }
    
    @ModelAttribute("vahtkondintsidendises")
    public Collection<VahtkondIntsidendis> VahtkondIntsidendisController.populateVahtkondIntsidendises() {
        return VahtkondIntsidendis.findAllVahtkondIntsidendises();
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
