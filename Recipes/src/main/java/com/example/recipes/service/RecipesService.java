package com.example.recipes.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.recipes.exceptions.RecipeExceptions;
import com.example.recipes.persistance.domain.Recipes;
import com.example.recipes.persistance.repo.RecipeReop;

@Service
public class RecipesService {

	private RecipeReop repo;
	
	private List<Recipes> recipes = new ArrayList<>(Arrays.asList(
			new Recipes( "cake", "cake", "cake", 4),
			new Recipes("bat","bat", "bisc", 3),
			new Recipes("angel slice", "slice", "vanilla", 7 )
			));
			

	public RecipesService(RecipeReop repo) {
		super();
		this.repo = repo;
	}
	public Recipes createRecipes(Recipes recipe) {
		return this.repo.save(recipe);
	}

	public List<Recipes> getRecipe() {
		return (List<Recipes>) this.repo.findAll(); 
	}

	public Recipes updateRecipes(Recipes recipe, Long id) {
		
		Optional<Recipes> optRecipe = this.repo.findById(id);
		Recipes oldRecipe = optRecipe.orElseThrow(() -> new RecipeExceptions());

		oldRecipe.setName(recipe.getName());
		oldRecipe.setType(recipe.getType());
		oldRecipe.setFlavour(recipe.getFlavour());
		oldRecipe.setNoIngred(recipe.getNoIngred());


		Recipes saved = this.repo.save(oldRecipe);
		return saved;
	}

	public boolean deleteRecipes(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
