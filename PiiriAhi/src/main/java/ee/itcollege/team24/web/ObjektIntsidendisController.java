package ee.itcollege.team24.web;

import ee.itcollege.team24.entities.ObjektIntsidendis;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "objektintsidendises", formBackingObject = ObjektIntsidendis.class)
@RequestMapping("/objektintsidendises")
@Controller
public class ObjektIntsidendisController {
}
