package pl.olszanka.HigroTempApplication.thymeleafControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class homeController {

    @GetMapping
    public String showHome(){
        return "home";
    }

}
