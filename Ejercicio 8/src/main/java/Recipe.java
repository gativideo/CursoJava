/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iss20
 */


import java.util.ArrayList;

public class Recipe {
    private String name;
    private int cookingTime;
    private ArrayList<String> ingredients;
    
    public Recipe(String name, int cookingTime) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = new ArrayList<>();
    }
    
    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }
    
    //contains() es para saber si un string tiene una secuencia determinada de caracteres. Por ejemplo "He" está contenido en "Hello", y daría true.
    //Supongo que sería lo mismo usar this.name.equals(searchedFor)
    public boolean nameContains(String searchedFor) {
        return this.name.contains(searchedFor);
    }
    
    public boolean cookingTimeAtMost(int max) {
        return this.cookingTime <= max;
    }
    
    public boolean containsIngredient(String ingredient) {
        return this.ingredients.contains(ingredient);
    }
    
    public String toString() {
        return this.name + ", cooking time: " + this.cookingTime;
    }
    
    
    
    
}


/*import java.text.MessageFormat;
import java.util.List;

public class Recipe {

    private String name;
    private int cookTime;
    private List<String> ingredients;

    public Recipe(String name, int cookTime, List<String> ingredients) {
        this.name = name;
        this.cookTime = cookTime;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public Recipe setName(String name) {
        this.name = name;
        return this;
    }

    public int getCookTime() {
        return cookTime;
    }

    public Recipe setCookTime(int cookTime) {
        this.cookTime = cookTime;
        return this;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public Recipe setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}, cooking time: {1}", name, cookTime);
    }
}*/