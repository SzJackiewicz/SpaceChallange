import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Simulation {


    public Simulation(){
    }
    ArrayList<Item> loadItems (String fileName) throws FileNotFoundException{
        File file = new File("phase1.txt");
        Scanner scan = new Scanner(file);
        ArrayList<Item> items = new ArrayList<>();

        while (scan.hasNextLine()){
            String line = scan.nextLine();
            String[] oneItem = line.split("=");
            items.add(new Item(oneItem[0], Integer.valueOf(oneItem[1])));
        }
        System.out.println(fileName + " zawiera " + items.size() + " ładunku");
        return items;
        //funkcja wczytująca dane z listy
    }
ArrayList<Rocket> loadU1 (ArrayList<Item> list){
    ArrayList<Rocket> fleet = new ArrayList<>();
    Rocket r = new u1();

    int itemCounter = 1;
    int rocketCounter = 1;

    System.out.println("\nWaga U1 = " + r.rocketWeight + "; Max waga = " + r.maxWeight);

    for (Item i : list) {
        while (!r.canCarry(i)){
            rocketCounter++;
            fleet.add(r);
            r = new u1();
        }
        r.carry(i);
        itemCounter++;
    }
    fleet.add(r);
    System.out.println("U1 zawiera " + fleet.size() + " rakieta");
    return fleet;
}
    ArrayList<Rocket> loadU2(ArrayList<Item> list) {
        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket r = new u2();

        int itemCounter = 1;
        int rocketCounter = 1;

        System.out.println("Waga U2 = " + r.rocketWeight + "; max waga = " + r.maxWeight);

        for (Item i : list) {

            while (!r.canCarry(i)) {

                rocketCounter++;
                fleet.add(r);
                r = new u2();
            }
            r.carry(i);


            itemCounter++;
        }
        fleet.add(r);
        System.out.println("U2 zawiera " + fleet.size() + " rakieta \n");
        return fleet;
    }


    int runSimulation(ArrayList<Rocket> list) {
        int num = 0;
        int indexSuccess = 1;
        for (Rocket r : list) {

            while (!r.launch()) {
                r.launch();
                num++;

            }

            while (!r.land()) {
                r.land();
                num++;
            }
            indexSuccess++;
        }
        int budget = list.get(0).rocketCost * (list.size() + num);
        System.out.println(list.size() + " rakiet" + num + " dodatkowych prób = "
                + (list.size() + num));
        return budget;
    }


    public static void main(String[] args) throws FileNotFoundException {
        // OBIEKT SYMULACJA
        Simulation sim = new Simulation();

        //FAZA 1
        ArrayList<Item> phase1 = sim.loadItems("phase1.txt");
        ArrayList<Item> phase2 = sim.loadItems("phase2.txt");


        // ŁADOWANIE RAKIET
        ArrayList<Rocket> u1FleetPhase1 = sim.loadU1(phase1);
        ArrayList<Rocket> u1FleetPhase2 = sim.loadU1(phase2);


        // URUCHOMIENIE SYMULACJI U1
        System.out.println("\nKoszt rakiety U1= 100");
        int budgetU1phase1 = sim.runSimulation(u1FleetPhase1);
        System.out.println("Budżet fazy pierszej dla U1 = " + budgetU1phase1 + " (milionów)");

        int budgetU1phase2 = sim.runSimulation(u1FleetPhase2);
        System.out.println("Budżet fazy drugiej dla U1 = " + budgetU1phase2 + " (milionów)");

        System.out.println("Łączny budżet dla lotów U1 = " + (budgetU1phase1 + budgetU1phase2) + " (milionów)\n");


        // URUCHOMIENIE SYMULACJI U2
        ArrayList<Rocket> u2FleetPhase1 = sim.loadU2(phase1);
        ArrayList<Rocket> u2FleetPhase2 = sim.loadU2(phase2);
        System.out.println("\nKoszt rakiety u2 = 120");
        int budgetU2phase1 = sim.runSimulation(u2FleetPhase1);
        System.out.println("Budżet fazy pierszej dla U2 = " + budgetU2phase1 + " (milionów)");

        int budgetU2phase2 = sim.runSimulation(u2FleetPhase2);
        System.out.println("Budżet fazy drugiej dla U2 = " + budgetU2phase2 + " (milionów)");

        System.out.println("Łączny budżet lotów= " + (budgetU2phase1 + budgetU2phase2) + " (milionów)\n");

    }
}





