
/*import java.util.Scanner;
import java.util.ArrayList;*/

/*import java.util.ArrayList;
import java.util.List;
import java.util.Objects;*/
import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {
        // NB! Do not create other scanner objects than the one below
        // if and when you create other classes, pass the scanner to them
        // as a parameter
       /* ArrayList<Bird> list = new ArrayList<>();
        while (true) {
            System.out.println("?");
            Scanner scan = new Scanner(System.in); //Esto es lo único que venia originalmente
            String input = scan.nextLine();
            
            if(input.equals("Quit")) {
                break;
            }
            if(input.equals("Add")) {
                //Bird bird = new Bird();
                System.out.println("Name: ");
                String name = scan.nextLine();
                //bird.setName(name);
                System.out.println("Name in Latin: ");
                String nameInLatin = scan.nextLine();
                //bird.setNameInLatin(nameInLatin);
                //list.add(bird);
                list.add(new Bird (name, nameInLatin));
                continue;
            }
            if(input.equals("Observation")) {
                System.out.println("Bird? ");
                String observedBird = scan.nextLine();
                int counter = 0;
                for(int i = 0; i < list.size(); i++) {
                    //int counter = 0;
                    if(list.get(i).getName().equals(observedBird)) {
                        list.get(i).addOneObservation();
                    }
                    if(!(list.get(i).getName().equals(observedBird))) {
                        counter = counter + 1;
                    }
                    if (counter == list.size()) {
                        System.out.println("Not a bird!");
                    }
                }
            }
            if(input.equals("All")) { 
                for(int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i).toString());
                }
            }
            if(input.equals("One")) {
                System.out.println("Bird? ");
                String oneToPrint = scan.nextLine(); 
                for(int i = 0; i < list.size(); i++) {
                    if(list.get(i).getName().equals(oneToPrint)) {
                        System.out.println(list.get(i).toString());
                    }
                }
            }
        }*/
       
        /*Scanner sc = new Scanner(System.in);

        final List<Bird> birds = new ArrayList<>();

        while (true) {
            System.out.print("? ");
            final String command = sc.nextLine();

            if ("quit".equalsIgnoreCase(command)) {
                break;
            }

            if ("one".equalsIgnoreCase(command)) {
                System.out.print("Bird? ");
                final String name = sc.nextLine();

                birds.stream()
                        .filter(b -> Objects.equals(b.getName(), name))
                        .findFirst()
                        .ifPresent(System.out::println);
            }

            if ("add".equalsIgnoreCase(command)) {
                System.out.print("Name: ");
                final String name = sc.nextLine();
                System.out.print("Name in Latin: ");
                final String latinName = sc.nextLine();

                birds.add(new Bird(name, latinName));
            }

            if ("observation".equalsIgnoreCase(command)) {
                System.out.print("Bird? ");
                final String name = sc.nextLine();

                final Bird queriedBird = birds.stream()
                        .filter(b -> Objects.equals(b.getName(), name))
                        .findFirst()
                        .orElse(null);

                if (queriedBird == null) {
                    System.out.println("Not a bird!");
                    continue;
                }
                queriedBird.increaseObservationCount();

            }

            if ("all".equalsIgnoreCase(command)) {
                for (Bird bird : birds) {
                    System.out.println(bird);
                }
            }
        }*/
        Scanner scan = new Scanner(System.in);
        
        BirdDatabase birdbase = new BirdDatabase();
        
        UserInterface ui = new UserInterface(scan, birdbase);
        ui.start();
        

    }

}
