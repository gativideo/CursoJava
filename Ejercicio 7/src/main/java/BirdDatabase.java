/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iss20
 */

//El objeto instanciado por esta clase es un array.
//Es como que está encerrando al array, entonces para qué lo creo?
//Porque así separo las funcionalidades que tienen que ver con
//el arraylist, como agregar elementos, traer elementos de acuerdo a lo que pide el usuario, etc
import java.util.ArrayList;
public class BirdDatabase {
    private ArrayList<Bird> birds;
    
    public BirdDatabase() {
        this.birds = new ArrayList<>();
    }
    
    //Si la observacion corresponde a algo que está en la lista le agrega una observación y devuelve true. Sino devuelve false.
    public boolean observation(String name) {
        for(int i = 0; i < this.birds.size(); i++) {
            if(birds.get(i).getName().equals(name)) {
                birds.get(i).addOneObservation();
                return true;
            }
        }
        return false;
    }
    
    //Cuando usamos este metodo se crea un nuevo objeto Bird, con su nombre y nombre en latin correspondiente, y se lo agrega a la BirdDatabase.
    public void add(String name, String nameInLatin) {
        this.birds.add(new Bird(name, nameInLatin));
    }
    
    //Recorremos el array. Si una de las aves coincide con la que
    //le pasamos como parámetro imprime la frase armada en la clase Bird
    public String getOne(String name) {
        for(int i = 0; i < this.birds.size(); i++) {
            if(this.birds.get(i).getName().equals(name)) {
                return this.birds.get(i).toString();
            }
        }
        return null;
    }
    
    public String getAll() {
        String allBirds = "";
        for(int i = 0; i < this.birds.size(); i++) {
            allBirds = allBirds + this.birds.get(i).toString();
        }
        return allBirds;
    }
}
