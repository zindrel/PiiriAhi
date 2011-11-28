package ee.itcollege.team24.web;

import ee.itcollege.team24.entities.IsikIntsidendis;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "isikintsidendises", formBackingObject = IsikIntsidendis.class)
@RequestMapping("/isikintsidendises")
@Controller
public class IsikIntsidendisController {
}
