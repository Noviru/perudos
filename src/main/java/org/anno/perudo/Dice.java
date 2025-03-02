package main.java.org.anno.perudo;
import java.util.Random;

public class Dice {
    private int value;
    Random rand = new Random();

    public Dice() {
        this.value = rand.nextInt(6) + 1;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
