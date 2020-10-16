package com.example.recipes.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipes.dto.RecipesDTO;
import com.example.recipes.persistance.domain.Recipes;
import com.example.recipes.service.RecipesService;

@RestController
@CrossOrigin
public class RecipeController {

	private RecipesService service;

	public RecipeController(RecipesService service) {
		super();
		this.service = service;
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "Hello, World!";
	}

	@PostMapping("/create")
	public ResponseEntity<Recipes> createRecipe(@RequestBody Recipes recipe) {
		return new ResponseEntity<Recipes>(this.service.createRecipes(recipe), HttpStatus.CREATED);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> deleteRecipe(@PathVariable Long id) {
		if (this.service.deleteRecipes(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get")
	public ResponseEntity<List<Recipes>> getRecipe() {
		return ResponseEntity.ok(this.service.getRecipe());
	}

	@PutMapping("/update")
	public ResponseEntity<Recipes> updateRecipe(@RequestBody Recipes recipe, @PathParam("id") Long id) {
		return new ResponseEntity<Recipes>(this.service.updateRecipes(recipe, id), HttpStatus.ACCEPTED);
	}

}
