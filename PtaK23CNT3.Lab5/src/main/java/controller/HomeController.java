package controller;

import entity.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {

        List<Info> profile = new ArrayList<>();
        profile.add(new Info(
                "DevMaster Academy",
                "Pta",
                "tuan@gmail.com",
                "https://devmaster.edu.vn"
        ));


        model.addAttribute("profile", profile);

        return "profile";
    }
}
