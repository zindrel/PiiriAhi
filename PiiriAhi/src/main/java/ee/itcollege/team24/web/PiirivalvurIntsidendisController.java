package ee.itcollege.team24.web;

import ee.itcollege.team24.entities.PiirivalvurIntsidendis;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "piirivalvurintsidendises", formBackingObject = PiirivalvurIntsidendis.class)
@RequestMapping("/piirivalvurintsidendises")
@Controller
public class PiirivalvurIntsidendisController {
}
