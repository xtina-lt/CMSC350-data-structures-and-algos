import java.util.ArrayList;

public class Mammal {
    public static ArrayList<Mammal> holds = new ArrayList<Mammal>();
    public static int FULL = 100;
    private String name;
    private int energy = 100;
    private String sound;
    private String species = "Mammalllian";

    // CONSTRUCTOR
    public Mammal(String name) {
        this.name = name;
    }

    // ACCESSORS
    @Override
    public String toString(){
        return String.format("My name is %s(%s) with %d energy!", name, species, energy);
    }
    public String getName(){
        return name;
    }
    public int getEnergy(){
        return energy;
    }
    public void getInfo(){
        System.out.printf("My name is %s(%s)!\nI have %d energy!\n", name, species, energy);
    }

    // MUTATORS
    public String setName(String name){
        return this.name = name;
    }
    public int giveFood(){
        return energy+=10;
    }
    public int getSleep(){
        return energy=FULL;
    }
    public int play(){
        if (energy - 10 >= 0) {
            return this.energy-=10;
        } else {
            throw new IllegalArgumentException("Not enough energy to play");
        }
    }
}
