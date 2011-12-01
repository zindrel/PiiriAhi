package ee.itcollege.team24.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ee.itcollege.team24.entities.Intsident;
import ee.itcollege.team24.entities.Piiriloik;

@RequestMapping("/intidentpiiril/**")
@Controller
public class IntidentPiirilController {

    @RequestMapping
    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    	modelMap.addAttribute("piiriloiks",Piiriloik.findAllPiiriloiks());
    	modelMap.addAttribute("intsidents",Intsident.findAllIntsidents());
    	modelMap.addAttribute("number",Intsident.countIntsidents());
        return "intidentpiiril/index";
    }

}
