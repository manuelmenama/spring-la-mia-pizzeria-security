package org.lessons.springlamiapizzeriacrud.controller;

import jakarta.validation.Valid;
import org.lessons.springlamiapizzeriacrud.exceptions.IngredientNotFoundException;
import org.lessons.springlamiapizzeriacrud.model.AlertMessage;
import org.lessons.springlamiapizzeriacrud.model.Ingredient;
import org.lessons.springlamiapizzeriacrud.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping
    public String index(@RequestParam Optional<Integer> idParam, Model model) {
        model.addAttribute("allIngredient", ingredientService.findAllIngredients());
        Ingredient ingredientToUpdate = null;
        if (idParam.isPresent()) {
            ingredientToUpdate = ingredientService.getIngredientById(idParam.get());
            model.addAttribute("newIngredient", ingredientToUpdate);
        } else {
            model.addAttribute("newIngredient", new Ingredient());
        }

        return "/ingredients/index";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(name="newIngredient") Ingredient ingredient,
                         BindingResult bindingResult,
                         Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("allIngredient", ingredientService.findAllIngredients());
            return "/ingredients/index";
        }

        if (ingredient.getId() != null) {
            ingredientService.update(ingredient);
        } else {
            ingredientService.create(ingredient);
        }

        return "redirect:/ingredients";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) throws RuntimeException{
        try {
            boolean success = ingredientService.delete(id);
            if (success) {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessage.AlertMessageType.SUCCESS, "Elemento " + id + " eliminato con successo."));
            } else {
                redirectAttributes.addFlashAttribute("message",
                        new AlertMessage(AlertMessage.AlertMessageType.ERROR, "L'eliminazione dell'elemento con id " + id + " fallita."));
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message",
                    new AlertMessage(AlertMessage.AlertMessageType.ERROR, "Elemento con id " + id + " non trovato"));
        }
        return "redirect:/ingredients";
    }

 /*   @GetMapping("/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) throws IngredientNotFoundException {
        Optional<Ingredient> ingredientToUpdate = ingredientService.getIngredientById(id);
        if (ingredientToUpdate.isPresent()) {
            model.addAttribute("newIngredient", ingredientToUpdate);
            model.addAttribute("allIngredient", ingredientService.findAllIngredients());
            return "/ingredients/index";
        } else {
            throw new IngredientNotFoundException("Ingrediente con id " + id + " non trovato");
        }
    }*/
}
