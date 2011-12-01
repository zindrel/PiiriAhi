package ee.itcollege.team24.web;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ee.itcollege.team24.entities.Intsident;

@RooWebScaffold(path = "registerincident", formBackingObject = Intsident.class)
@RequestMapping("/registerincident")
@Controller
public class RegisterIncidentController {

}
