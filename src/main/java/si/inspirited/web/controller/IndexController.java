package si.inspirited.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    //@RequestMapping("index")
    public ModelAndView index() {
        String param = "Viktorichka Shtoda(Karaslay) my beloved";
        ModelAndView model = new ModelAndView("index");
        model.addObject("message", param);
        return model;
    }

    @RequestMapping("i")
    public ModelAndView i() {
        String param = "Viktorichka Shtoda(Karaslay) my beloved";
        ModelAndView model = new ModelAndView("pindex");
        model.addObject("message", param);

        return model;
    }
}



























