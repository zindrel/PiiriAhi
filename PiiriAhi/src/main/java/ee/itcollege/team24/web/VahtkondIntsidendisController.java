package ee.itcollege.team24.web;

import ee.itcollege.team24.entities.VahtkondIntsidendis;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "vahtkondintsidendises", formBackingObject = VahtkondIntsidendis.class)
@RequestMapping("/vahtkondintsidendises")
@Controller
public class VahtkondIntsidendisController {
}
