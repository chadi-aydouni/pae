package g43729.webg5.pae.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Page d'accueil
    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("username", "XXX");
        return "home";
    }
}
