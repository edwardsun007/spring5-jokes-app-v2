package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {
    private final JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    // Handle request that use URL like / or empty string -- root
    @RequestMapping({"/",""})
    public String showJoke(Model model){
        // adding attribute to the model with mapping "joke" : one of the random joke from the service
        model.addAttribute("joke", jokeService.getJoke());
        return "index"; // Tells Spring MVC to render the index view, this requires
    }


}
