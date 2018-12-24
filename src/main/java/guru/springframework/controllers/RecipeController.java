package guru.springframework.controllers;

import guru.springframework.exceptions.NotFoundException;
import guru.springframework.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/recipe")
@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/{id}/show")
    public String showRecipe(Model model, @PathVariable Long id) {
        System.out.println(id);
        model.addAttribute("recipe", recipeService.findById(id));
        return "recipe/show";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("404error");
        mav.addObject("exception", ex);
        return mav;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleBadInputRecipeId(Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("400error");
        mav.addObject("exception", ex);
        return mav;
    }

}
