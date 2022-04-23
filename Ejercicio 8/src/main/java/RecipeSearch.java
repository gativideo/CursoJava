
//import java.nio.file.Paths;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Recipe> recipes = new ArrayList<>(); //Creamos una lista cuyo contenido son objetos instanciados de Recipe.
        
        System.out.println("File to read: ");
        String fileToRead = scanner.nextLine();

        try (Scanner fileReader = new Scanner(new File(fileToRead))) {
            while(fileReader.hasNextLine()) {
                String recipeName = fileReader.nextLine();  //leemos la primera línea de la receta, que es el nombre de la receta. Lo guardamos en una variable
                int recipeTime = Integer.valueOf(fileReader.nextLine());  //leemos la segunda línea, que es el tiempo de coccion. Lo guardamos en una variable
                Recipe recipe = new Recipe(recipeName, recipeTime); //Creamos un objeto de la clase Recipe.
                
                recipes.add(recipe); //Agregamos el objeto recipe a la lista recipes
                
                while(fileReader.hasNextLine()) {
                    String ingredient = fileReader.nextLine();  //La siguiente línea corresponde a un ingrediente, asi que lo leemos y lo guardamos en una variable.
                    //Si lee una línea vacía se sale de éste loop y regresa al loop contenedor.
                    if(ingredient.isEmpty()) {  //(Este if está antes de agregar los ingredientes porque si está vacío no lo agrega)
                        break;
                    }
                    recipe.addIngredient(ingredient);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Commands:\n"
                + "list - lists the recipes\n"
                + "stop - stops the program\n"
                + "find name - searches recipes by name\n"
                + "find cooking time - searches recipes by cooking time\n"
                + "find ingredient - searches recipes by ingredient");
        
        while(true) {
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            if (command.equals("list")) {
                System.out.println("Recipes: ");
                for(Recipe recipe : recipes) {
                    System.out.println(recipe);
                }
            }
            if (command.equals("find name")) {
                System.out.println("Searched word: ");
                String searchedFor = scanner.nextLine();
                for(Recipe recipe : recipes) {
                    if(recipe.nameContains(searchedFor)) {
                        System.out.println(recipe);
                    }
                }
            }
            if (command.equals("find cooking time")) {
                System.out.println("Max cooking time: ");
                int max = Integer.valueOf(scanner.nextLine());
                for(Recipe recipe : recipes) {
                    if(recipe.cookingTimeAtMost(max)) {
                        System.out.println(recipe);
                    }
                }
            }
            
            if(command.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                String ingredient = scanner.nextLine();
                
                for(Recipe recipe : recipes) {
                    if(recipe.containsIngredient(ingredient)) {
                        System.out.println(recipe);
                    }
                }
            }
            
        }
        
        
        
     
        
       
               
        
        

    }
    

}


/*
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("File to read: ");
        final String file = sc.nextLine();

        final List<Recipe> recipes = readRecipesFromFile(file);
        System.out.println("Commands");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.println("Enter command: ");
            final String input = sc.nextLine();

            if ("list".equalsIgnoreCase(input)) {
                for (Recipe recipe : recipes) {
                    System.out.println(recipe);
                }
            }

            if ("stop".equalsIgnoreCase(input)) {
                break;
            }

            if ("find name".equalsIgnoreCase(input)) {
                System.out.println("Searched word: ");
                final String query = sc.nextLine();
                for (Recipe recipe : recipes) {
                    if (recipe.getName().contains(query)) {
                        System.out.println(recipe);
                    }
                }
            }

            if ("find cooking time".equalsIgnoreCase(input)) {
                System.out.println("Max cooking time: ");
                final int query = Integer.parseInt(sc.nextLine());
                for (Recipe recipe : recipes) {
                    if (recipe.getCookTime() <= query) {
                        System.out.println(recipe);
                    }
                }
            }

            if ("find ingredient".equalsIgnoreCase(input)) {
                System.out.println("Ingredient: ");
                final String query = sc.nextLine();
                for (Recipe recipe : recipes) {
                    for (String ingredient : recipe.getIngredients()) {
                        if (Objects.equals(ingredient, query)) {
                            System.out.println(recipe);
                        }
                    }
                }
            }
        }

    }

    public static List<Recipe> readRecipesFromFile(String filename) {
        final List<Recipe> recipes = new ArrayList<>();
        final List<String> recipeParts = new ArrayList<>();

        try (Scanner sc = new Scanner(Paths.get(filename))) {
            while (sc.hasNextLine()) {
                final String line = sc.nextLine();
                if (!line.isEmpty()) {
                    recipeParts.add(line);
                } else {
                    assignRecipeParts(recipes, recipeParts);
                }
            }
            if (!recipeParts.isEmpty()) {
                assignRecipeParts(recipes, recipeParts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return recipes;

    }

    private static void assignRecipeParts(List<Recipe> recipes, List<String> recipeParts) {
        String recipeName;
        int cookTime;
        recipeName = recipeParts.get(0);
        cookTime = Integer.parseInt(recipeParts.get(1));
        recipeParts.remove(0);
        recipeParts.remove(0);
        recipes.add(new Recipe(recipeName, cookTime, new ArrayList<>(recipeParts)));
        recipeParts.clear();
    }

}
*/