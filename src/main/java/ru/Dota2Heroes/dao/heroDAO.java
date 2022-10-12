package ru.Dota2Heroes.dao;

import org.springframework.stereotype.Component;
import ru.Dota2Heroes.heroModels.Hero;
import java.util.ArrayList;
import java.util.List;

@Component
public class heroDAO {

    private static int HERO_COUNT;
    private List<Hero> heroes;

    {
        heroes = new ArrayList<>();

        heroes.add(new Hero(++HERO_COUNT, "Axe", "Tank"));
        heroes.add(new Hero(++HERO_COUNT, "Invoker", "Mid"));
        heroes.add(new Hero(++HERO_COUNT, "Drow Ranger", "Carry"));
    }

    public List<Hero> index() {
        return heroes;
    }

    public Hero show(int id) {
        return heroes.stream().filter(hero -> hero.getId() == id).findAny().orElse(null);

    }
}
