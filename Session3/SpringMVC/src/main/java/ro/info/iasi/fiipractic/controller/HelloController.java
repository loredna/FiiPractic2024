package ro.info.iasi.fiipractic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/users/")
    public ModelAndView greet(@RequestParam("name") String name) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("name", name);

        return mv;
    }
}
