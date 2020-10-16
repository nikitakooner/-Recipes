package com.example.recipes.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.recipes.persistance.domain.Recipes;


// JPA -> Java Persistence API

@Repository
public interface RecipeReop extends CrudRepository <Recipes, Long> {

}
