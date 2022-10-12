package ru.Dota2Heroes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.Dota2Heroes.dao.heroDAO;

@Controller
@RequestMapping("/hero")
public class HeroController {

    private final heroDAO heroDAO;

    public HeroController(heroDAO heroDAO) {
        this.heroDAO = heroDAO;
    }

    @GetMapping()
    public String showall(Model model) {
        model.addAttribute("hero", heroDAO.index());
        return "hero/showall";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("hero", heroDAO.show(id));

        return "hero/show";
    }
}
