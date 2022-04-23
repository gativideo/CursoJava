/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iss20
 */

import java.util.Scanner;
public class UserInterface {
    private Scanner scan;
    private BirdDatabase birdbase;
    
    public UserInterface(Scanner scan, BirdDatabase birdbase) {
        this.scan = scan;
        this.birdbase = birdbase;
    }
    
    //Este método primero imprime la pregunta y nos retorna lo que el usuario contesta. (Eso que nos retorna despues lo podemos guardar en una variable)
    public String askUserInput(String prompt) {
        System.out.println(prompt + " ");
        return scan.nextLine();
    }
    
    //Este método al usar el método askUserInput perimero imprime la pregunta
    //y retorna la respuesta, que son guardadas en las variables.
    //Luego esos valores se agregan a la database mediante el método add.
    public void add() {
        String name = askUserInput("Name:");
        String nameInLatin = askUserInput("Name in Latin:");
        birdbase.add(name, nameInLatin);
    }
    
    
    //Primero imprime la pregunta de qué es lo que se observó. Eso se guarda en la variable name.
    //El método observation con parámetro name aplicado a birdbase nos dice si ese name se encuentra en la birdbase
    //Si se encuentra se va a ejecutar el otro método que cuenta las observaciones y ademas retorna true, entonces wasSuccesfull va a ser true.
    //Si no se encuentra se imprime is not a bird!
    public void observation() {
        String name = askUserInput("Name:");
        
        boolean wasSuccesfull = birdbase.observation(name);
        if (!wasSuccesfull) {
            System.out.println(name + "is not a bird!");
        }
    }
    
    public void printOne() {
        String name = askUserInput("Name:");
        String birdToPrint = birdbase.getOne(name);
        if (birdToPrint == null) {
            System.out.println(name + "is not a bird!");
        } else {
            System.out.println(birdToPrint);
        }
    }
    
    public void printAll() {
        System.out.println(birdbase.getAll());
    }
    
    public void start() {
        while(true) {
            String command = askUserInput("?");
            
            if(command.equals("Quit")) {
                break;
            } else if (command.equals("Add")) {
                add();
            } else if (command.equals("Observation")) {
                observation();
            } else if (command.equals("One")) {
                printOne();
            } else if (command.equals("All")) {
                printAll();
            } else {
                System.out.println("Unknown command!" );
            }
            
        }
    }
}
